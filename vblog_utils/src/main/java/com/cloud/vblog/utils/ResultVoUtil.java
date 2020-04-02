package com.cloud.vblog.utils;


import com.cloud.vblog.common.enums.ResultEnum;
import com.cloud.vblog.common.vo.ResultVo;

/**
 * @author aiwei
 */
public class ResultVoUtil {

    public static ResultVo success(Object object) {
        ResultVo ResultVo = new ResultVo();
        ResultVo.setCode(0);
        ResultVo.setMsg("success");
        ResultVo.setData(object);
        return ResultVo;
    }

    public static ResultVo success() {
        ResultVo ResultVo = new ResultVo();
        ResultVo.setCode(0);
        ResultVo.setMsg("success");
        return ResultVo;
    }

    public static ResultVo error(ResultEnum resultEnum) {
        ResultVo ResultVo = new ResultVo();
        ResultVo.setCode(resultEnum.getCode());
        ResultVo.setMsg(resultEnum.getMessage());
        return ResultVo;
    }
    public static ResultVo error(String errMsg) {
        ResultVo ResultVo = new ResultVo();
        ResultVo.setCode(-1);
        ResultVo.setMsg(errMsg);
        return ResultVo;
    }
}
