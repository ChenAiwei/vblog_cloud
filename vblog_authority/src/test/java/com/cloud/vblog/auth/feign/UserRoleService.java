package com.cloud.vblog.auth.feign;

import com.cloud.vblog.auth.service.IUserAuthService;
import com.cloud.vblog.common.dto.auth.UserAuthDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author：chenaiwei
 * @Description：UserRoleService
 * @CreateDate：2020/4/3 14:18
 */
public class UserRoleService extends BaseAuthFeign {
	@Autowired
	private IUserAuthService userAuthService;

	@Test
	public void info(){
		List<UserAuthDto> info = userAuthService.info(null);
		System.out.println(" = " + info.toString() + "," + "当前类=UserRoleService.info()");
	}
}
