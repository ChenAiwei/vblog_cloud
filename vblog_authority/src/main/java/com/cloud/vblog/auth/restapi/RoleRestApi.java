package com.cloud.vblog.auth.restapi;

import com.cloud.vblog.auth.service.ITRoleService;
import com.cloud.vblog.common.dto.auth.RoleDto;
import com.cloud.vblog.common.dto.auth.UserRoleInfoDto;
import com.cloud.vblog.common.dto.auth.ValidationGroups;
import com.cloud.vblog.common.utils.ResultVoUtil;
import com.cloud.vblog.common.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

	@GetMapping("/queryRoleByName")
	public ResultVo<List<RoleDto>> queryRoleByName(@RequestParam("name") String name){
		return ResultVoUtil.success(roleService.queryRoleByName(name));
	}

	@GetMapping("/getRole/{uid}")
	public ResultVo<RoleDto> queryRoleById(@PathVariable String uid){
		return ResultVoUtil.success(roleService.queryRoleById(uid));
	}

	@PostMapping("/addRole")
	public ResultVo<?> addRole(@Validated(ValidationGroups.Register.class) @RequestBody RoleDto role){
		roleService.addRole(role);
		return ResultVoUtil.success();
	}

	@PostMapping("/editRole")
	public ResultVo<?> editRole(@Validated(ValidationGroups.Editer.class) @RequestBody RoleDto role) {
		roleService.editRole(role);
		return ResultVoUtil.success();
	}

	@GetMapping("/delRole/{uid}")
	public ResultVo<?> delRole(@PathVariable String uid){
		roleService.delRole(uid);
		return ResultVoUtil.success();
	}

	@GetMapping("/getRoleUserList/{uid}")
	public ResultVo<List<UserRoleInfoDto>> getRoleUserList(@PathVariable String uid){
		return ResultVoUtil.success(roleService.getRoleUserList(uid));
	}
}
