package com.cloud.vblog.common.dto.auth;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author：chenaiwei
 * @Description：RoleDto
 * @CreateDate：2020/4/3 8:55
 */
@Data
public class RoleDto implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 角色id
	 */
	private String uid;

	/**
	 * 角色名
	 */
	private String roleName;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 状态
	 */
	private Boolean status;

	/**
	 * 角色介绍
	 */
	private String summary;

}
