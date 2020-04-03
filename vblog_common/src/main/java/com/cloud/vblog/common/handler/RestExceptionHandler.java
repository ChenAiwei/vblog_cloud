package com.cloud.vblog.common.handler;

import com.cloud.vblog.common.enums.ResultEnum;
import com.cloud.vblog.common.exception.ServiceException;
import com.cloud.vblog.common.utils.ResultVoUtil;
import com.cloud.vblog.common.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author aiwei
 */
@ControllerAdvice
@Slf4j
public class RestExceptionHandler {

	@Value("${spring.profiles.active}")
	private String profiles;

	private static final String PRO_FILE_STR = "prod";

	/**
	 * http请求的方法不正确
	 *      
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseBody
	public ResultVo<Object> httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException e) {
		log.error("http请求的方法不正确:【" + e.getMessage() + "】");
		return ResultVoUtil.error(ResultEnum.RequestMethodNotAllowed);
	}

	/**
	 * 请求参数不全
	 *      
	 */
	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseBody
	public ResultVo<Object> missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException e) {
		log.error("请求参数不全:【" + e.getMessage() + "】");
		return ResultVoUtil.error(ResultEnum.MissingServletRequestParameter);
	}

	/**
	 * 请求参数类型不正确
	 *      
	 */
	@ExceptionHandler(TypeMismatchException.class)
	@ResponseBody
	public ResultVo<Object> typeMismatchExceptionHandler(TypeMismatchException e) {
		log.error("请求参数类型不正确:【" + e.getMessage() + "】");
		return ResultVoUtil.error(ResultEnum.TypeMismatchException);
	}


	/**
	 * 处理自定义的业务异常
	 *
	 * @param req
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = ServiceException.class)
	@ResponseBody
	public ResultVo<String> serviceExceptionHandler(HttpServletRequest req, ServiceException e) {
		log.error(e.getMessage());
		return ResultVoUtil.error(e.getMessage());
	}


	/**
	 * 处理其他异常
	 *
	 * @param req
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResultVo<String> exceptionHandler(HttpServletRequest req, Exception e) {
		log.error("发生异常！原因是:", e);
		if (PRO_FILE_STR.equals(profiles)) {
			return ResultVoUtil.error("系统异常");
		}
		int count = 0;
		StringBuffer stringBuffer = new StringBuffer();
		for (StackTraceElement stackTraceElement : e.getStackTrace()) {
			stringBuffer.append(stackTraceElement.toString()+"\r\n");
			if (count++ > 13){
				break;
			}
		}
		return ResultVoUtil.error(stringBuffer.toString());
	}
}
