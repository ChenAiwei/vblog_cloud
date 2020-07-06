package com.cloud.vblog.auth.restapi;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.vblog.auth.entity.TUserRole;
import com.cloud.vblog.auth.service.ITUserRoleService;
import com.cloud.vblog.auth.service.ITUserService;
import com.cloud.vblog.common.dto.auth.UserDto;
import com.cloud.vblog.common.dto.auth.ValidationGroups;
import com.cloud.vblog.common.utils.ResultVoUtil;
import com.cloud.vblog.common.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author：chenaiwei
 * @Description：UserRestApi
 * @CreateDate：2020/4/2 16:08
 */
@RestController
@RequestMapping("/auth/user")
@Slf4j
public class UserRestApi {

	@Autowired
	private ITUserService userService;
	@Autowired
	private ITUserRoleService userRoleService;

	@GetMapping("/queryByUserId/{uid}")
	public ResultVo<UserDto> queryByUserId(@PathVariable String uid){
		return ResultVoUtil.success(userService.queryByUserId(uid));
	}

	@GetMapping("/delUser/{uid}")
	@Transactional(rollbackFor = Exception.class)
	public ResultVo<?> delUser(@PathVariable String uid){
		userRoleService.remove(new QueryWrapper<TUserRole>().eq("user_id",uid));
		userService.removeById(uid);
		return ResultVoUtil.success();
	}

	@PostMapping("/addUser")
	public ResultVo<?> addUser(@Validated(ValidationGroups.Register.class) @RequestBody UserDto userDto){
		userService.saveUser(userDto);
		return ResultVoUtil.success();
	}

	@PostMapping("/editUser")
	public ResultVo<String> editUser(@Validated(ValidationGroups.Editer.class) @RequestBody UserDto userDto){
		userService.editUser(userDto);
		return ResultVoUtil.success();
	}


	@GetMapping("/queryByUserName")
	public ResultVo<List<UserDto>> queryByUserName(@RequestParam("name") String name){
		return ResultVoUtil.success(userService.queryByUserName(name));
	}
}
