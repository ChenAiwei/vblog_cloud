package com.cloud.vblog.auth.restapi;

import com.cloud.vblog.auth.service.IUserAuthService;
import com.cloud.vblog.common.dto.auth.UserAuthDto;
import com.cloud.vblog.common.utils.ResultVoUtil;
import com.cloud.vblog.common.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author：chenaiwei
 * @Description：UserAuthRestApi
 * @CreateDate：2020/4/3 8:42
 */
@RestController
@RequestMapping("/auth/info")
@Slf4j
public class UserAuthRestApi {

	@Autowired
	private IUserAuthService userAuthService;

	/**
	 * 根据uid获取用户的所有权限信息
	 * @param uid
	 * @return
	 */
	@GetMapping("/list/{uid}")
	public ResultVo<List<UserAuthDto>> list(@PathVariable String uid){
			return ResultVoUtil.success(userAuthService.info(uid));
	}

	@GetMapping("/listAll")
	public ResultVo<List<UserAuthDto>> listAll(){
		return ResultVoUtil.success(userAuthService.info(null));
	}
}
