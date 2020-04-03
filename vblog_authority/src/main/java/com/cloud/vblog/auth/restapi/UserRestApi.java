package com.cloud.vblog.auth.restapi;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.vblog.auth.entity.TUser;
import com.cloud.vblog.auth.service.ITUserService;
import com.cloud.vblog.common.dto.auth.UserDto;
import com.cloud.vblog.common.utils.ResultVoUtil;
import com.cloud.vblog.common.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

	@GetMapping("/getUser/{uid}")
	public ResultVo<UserDto> getUser(@PathVariable String uid){
		if (StringUtils.isBlank(uid)){
			return ResultVoUtil.error("uid为空");
		}
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userService.getById(uid),userDto);
		return ResultVoUtil.success(userDto);
	}

	@GetMapping("/delUser/{uid}")
	public ResultVo<String> delUser(@PathVariable String uid){
		if (StringUtils.isBlank(uid)){
			return ResultVoUtil.error("uid为空");
		}
		boolean b = userService.removeById(uid);
		if (b){
			return ResultVoUtil.success("删除成功");
		}else {
			return ResultVoUtil.error("删除失败");
		}
	}

	@PostMapping("/addUser")
	public ResultVo<String> addUser(@RequestBody UserDto userDto){
		TUser user = new TUser();
		BeanUtils.copyProperties(userDto,user);
		boolean save = userService.save(user);
		if (save){
			return ResultVoUtil.success("新增成功");
		}else {
			return ResultVoUtil.error("新增失败");
		}
	}

	@PostMapping("/editUser")
	public ResultVo<String> editUser(@RequestBody UserDto userDto){
		String uid = userDto.getUid();
		TUser user = userService.getById(uid);
		if (null == user){
			return ResultVoUtil.error("修改失败,用户不存在");
		}
		BeanUtils.copyProperties(userDto,user);
		user.setUid(uid);
		if (userService.updateById(user)){
			return ResultVoUtil.success("修改成功");
		}else{
			return ResultVoUtil.error("修改失败");
		}
	}


	@GetMapping("/queryByUserName}")
	public ResultVo<List<TUser>> queryByUserName(@RequestParam String name){
		return ResultVoUtil.success(userService.list(new QueryWrapper<TUser>().eq("user_name",name)));
	}
}
