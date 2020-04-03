package com.cloud.vblog.auth.mapper;

import com.cloud.vblog.auth.dto.UserRoleDto;
import com.cloud.vblog.common.dto.auth.UserAuthDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author：chenaiwei
 * @Description：UserAuthCustomMapper
 * @CreateDate：2020/4/3 9:07
 */
public interface UserAuthCustomMapper {
	/**
	 * uid获取用户的权限信息
	 * @param uid
	 * @return
	 */
	List<UserRoleDto> userRole(@Param("uid") String uid);
}
