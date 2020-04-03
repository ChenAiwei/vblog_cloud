package com.cloud.vblog.auth.service;

import com.cloud.vblog.auth.dto.UserRoleDto;
import com.cloud.vblog.common.dto.auth.UserAuthDto;

import java.util.List;

/**
 * @Author：chenaiwei
 * @Description：IUserAuthService
 * @CreateDate：2020/4/3 9:05
 */
public interface IUserAuthService {
	/**
	 * uid获取用户的权限信息
	 * @param uid
	 * @return
	 */
	List<UserAuthDto> info(String uid);

}
