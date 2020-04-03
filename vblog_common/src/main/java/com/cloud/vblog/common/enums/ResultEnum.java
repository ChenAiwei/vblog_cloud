package com.cloud.vblog.common.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    LoginFail(-1, "登录失败"),
    RoleError(-1, "角色权限有误"),
	MissingServletRequestParameter(400,"Missing servletRequest parameter"),
	TypeMismatchException(401,"Request parameter Type not match"),
    RequestMethodNotAllowed(405,"Request method not Allowed")
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
