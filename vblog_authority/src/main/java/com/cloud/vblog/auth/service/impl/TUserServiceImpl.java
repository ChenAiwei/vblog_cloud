package com.cloud.vblog.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.vblog.auth.entity.TRole;
import com.cloud.vblog.auth.entity.TUser;
import com.cloud.vblog.auth.entity.TUserRole;
import com.cloud.vblog.auth.mapper.TUserMapper;
import com.cloud.vblog.auth.service.ITRoleService;
import com.cloud.vblog.auth.service.ITUserRoleService;
import com.cloud.vblog.auth.service.ITUserService;
import com.cloud.vblog.common.dto.auth.RoleUserInfoDto;
import com.cloud.vblog.common.dto.auth.UserDto;
import com.cloud.vblog.common.exception.ServiceException;
import com.cloud.vblog.common.utils.UUIDUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author aiwei
 * @since 2020-04-02
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

	@Autowired
	private ITUserRoleService userRoleService;
	@Autowired
	private ITRoleService roleService;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void saveUser(UserDto userDto) {
		List<TUser> nameList = this.list(new QueryWrapper<TUser>().eq("user_name", userDto.getUserName()));
		if (CollectionUtils.isNotEmpty(nameList)){
			throw new ServiceException("用户名已存在");
		}
		TUser user = new TUser();
		BeanUtils.copyProperties(userDto,user);
		user.setUid(UUIDUtils.genUid());
		user.setCreateTime(new Date());
		this.save(user);
		this.saveUserRole(userDto,user.getUid());
	}

	private void saveUserRole(UserDto userDto, String uid) {
		if (CollectionUtils.isEmpty(userDto.getRoleUserInfoDtoList())){
			return;
		}
		List<String> roleIdList = userDto.getRoleUserInfoDtoList().stream().map(dto -> dto.getRoleId()).collect(Collectors.toList());
		Collection<TRole> roleCollection = roleService.listByIds(roleIdList);
		List<TUserRole> insertList = new ArrayList<>();
		roleCollection.forEach(role ->{
			TUserRole tUserRole = new TUserRole();
			tUserRole.setUid(UUIDUtils.genUid());
			tUserRole.setUserId(uid);
			tUserRole.setRoleId(role.getUid());
			insertList.add(tUserRole);
		});
		if (CollectionUtils.isNotEmpty(insertList)){
			userRoleService.saveBatch(insertList);
		}
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void editUser(UserDto userDto) {
		String uid = userDto.getUid();
		TUser user = this.getById(uid);
		if (null == user){
			throw new ServiceException("修改失败,用户不存在");
		}
		List<TUser> nameList = this.list(new QueryWrapper<TUser>().eq("user_name", userDto.getUserName()));
		if (CollectionUtils.isNotEmpty(nameList) && !nameList.get(0).getUid().equals(userDto.getUid())){
			throw new ServiceException("用户名已存在");
		}
		BeanUtils.copyProperties(userDto,user);
		user.setUid(uid);
		this.updateById(user);
		userRoleService.remove(new QueryWrapper<TUserRole>().eq("user_id",uid));
		this.saveUserRole(userDto,uid);
	}

	@Override
	public UserDto queryByUserId(String uid) {
		UserDto userDto = new UserDto();
		TUser user = this.getById(uid);
		if (null != user){
			BeanUtils.copyProperties(this.getById(uid),userDto);
		}
		userDto.setRoleUserInfoDtoList(this.getRoleUserList(uid));
		return userDto;
	}

	@Override
	public List<UserDto> queryByUserName(String name) {
		List<UserDto> resultList = new ArrayList<>();
		List<TUser> userList = this.list(StringUtils.isBlank(name) ? new QueryWrapper<>() : new QueryWrapper<TUser>().eq("user_name", name));
		userList.forEach(user ->{
			UserDto userDto = new UserDto();
			BeanUtils.copyProperties(user,userDto);
			userDto.setRoleUserInfoDtoList(this.getRoleUserList(user.getUid()));
			resultList.add(userDto);
		});
		return resultList;
	}

	public List<RoleUserInfoDto> getRoleUserList(String userId){
		List<RoleUserInfoDto> roleUserInfoDtoList = new ArrayList<>();
		List<TUserRole> userRoleList = userRoleService.list(new QueryWrapper<TUserRole>().eq("user_id", userId));
		if (CollectionUtils.isNotEmpty(userRoleList)){
			List<String> roleIdList = userRoleList.stream().map(e -> e.getRoleId()).collect(Collectors.toList());
			Collection<TRole> roleCollection = roleService.listByIds(roleIdList);
			roleCollection.forEach(role ->{
				roleUserInfoDtoList.add(new RoleUserInfoDto(userId,role.getUid(),role.getRoleName()));
			});
		}
		return roleUserInfoDtoList;
	}
}
