package com.cloud.vblog.auth.restapi;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.vblog.auth.entity.TRole;
import com.cloud.vblog.auth.service.ITRoleService;
import com.cloud.vblog.common.utils.ResultVoUtil;
import com.cloud.vblog.common.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author：chenaiwei
 * @Description：RoleRestApi
 * @CreateDate：2020/4/3 8:36
 */
@RestController
@RequestMapping("/auth/role")
@Slf4j
public class RoleRestApi {

	@Autowired
	private ITRoleService roleService;

	@GetMapping("/queryRole")
	public ResultVo<List<TRole>> queryRole(){
		return ResultVoUtil.success(roleService.list(new QueryWrapper<>()));
	}
}
