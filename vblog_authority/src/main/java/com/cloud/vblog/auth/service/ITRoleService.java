package com.cloud.vblog.auth.service;

import com.cloud.vblog.auth.entity.TRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.vblog.common.dto.auth.RoleDto;
import com.cloud.vblog.common.dto.auth.UserRoleInfoDto;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author aiwei
 * @since 2020-04-02
 */
public interface ITRoleService extends IService<TRole> {

	/**
	 * 角色添加
	 * @param role
	 */
	void addRole(RoleDto role);

	/**
	 * 角色编辑
	 * @param role
	 */
	void editRole(RoleDto role);

	/**
	 * 角色删除
	 * @param uid
	 */
	void delRole(String uid);

	/**
	 * ID查询角色下的用户
	 * @param uid
	 */
	List<UserRoleInfoDto> getRoleUserList(String uid);

	/**
	 * 角色名查询角色信息
	 * @param name
	 * @return
	 */
	List<RoleDto> queryRoleByName(String name);

	/**\
	 * 角色ID查询角色信息
	 * @param uid
	 * @return
	 */
	RoleDto queryRoleById(String uid);
}
