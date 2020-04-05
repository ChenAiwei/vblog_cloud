package com.cloud.vblog.common.dto.auth;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author：chenaiwei
 * @Description：UserDto
 * @CreateDate：2020/4/2 16:26
 */
@Data
public class UserDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 唯一uid
	 */
	private String uid;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 密码
	 */
	private String passWord;

	/**
	 * 昵称
	 */
	private String nickName;

	/**
	 * 性别(1:男2:女)
	 */
	private Boolean gender;

	/**
	 * 个人头像
	 */
	private String avatar;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 出生年月日
	 */
	private Date birthday;

	/**
	 * 手机
	 */
	private String mobile;

	/**
	 * 登录次数
	 */
	private Integer loginCount;

	/**
	 * 最后登录时间
	 */
	private Date lastLoginTime;

	/**
	 * 最后登录IP
	 */
	private String lastLoginIp;

	/**
	 * 状态
	 */
	private Boolean status;

	/**
	 * 平台uuid
	 */
	private String uuid;

	/**
	 * QQ号
	 */
	private String qqNumber;

	/**
	 * 微信号
	 */
	private String weChat;

	/**
	 * 评论状态 1:正常 0:禁言
	 */
	private Boolean commentStatus;

	/**
	 * 浏览器
	 */
	private String browser;

	/**
	 * 操作系统
	 */
	private String os;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 更新时间
	 */
	private Date updateTime;
}
