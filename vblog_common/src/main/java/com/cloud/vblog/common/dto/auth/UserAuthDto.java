package com.cloud.vblog.common.dto.auth;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * @Author：chenaiwei
 * @Description：UserAuthDto
 * @CreateDate：2020/4/3 8:51
 */
@Data
public class UserAuthDto implements Serializable {
	private String userId;
	private String userName;
	private String nickName;
	private Integer gender;
	private String avator;
	private String emial;
	private LocalDate birthday;
	private String mobile;
	private Integer loginCount;
	private LocalDate lastLoginTime;
	private String lastLoginIp;
	private Integer userStatus;
	private String uuid;
	private String qqNumber;
	private String weChat;
	private Integer commentStatus;
	private String browser;
	private String os;
	private List<RoleDto> roleList;
	private List<CategoryMenuDto> categoryMenuDtoList;
}
