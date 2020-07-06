package com.cloud.vblog.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.vblog.auth.entity.TUser;
import com.cloud.vblog.common.dto.auth.UserDto;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author aiwei
 * @since 2020-04-02
 */
public interface ITUserService extends IService<TUser> {

	/**
	 * 用户添加
	 * @param userDto
	 * @return
	 */
	void saveUser(UserDto userDto);

	/**
	 * 用户修改
	 * @param userDto
	 * @return
	 */
	void editUser(UserDto userDto);

	/**
	 * 用户ID 查询用户信息
	 * @param uid
	 * @return
	 */
	UserDto queryByUserId(String uid);

	/**
	 * 用户名 查询用户信息
	 * @param name
	 * @return
	 */
	List<UserDto> queryByUserName(String name);
}
