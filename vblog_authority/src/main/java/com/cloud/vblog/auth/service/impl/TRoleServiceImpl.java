package com.cloud.vblog.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.vblog.auth.entity.TRole;
import com.cloud.vblog.auth.entity.TUser;
import com.cloud.vblog.auth.entity.TUserRole;
import com.cloud.vblog.auth.mapper.TRoleMapper;
import com.cloud.vblog.auth.service.ITRoleService;
import com.cloud.vblog.auth.service.ITUserRoleService;
import com.cloud.vblog.auth.service.ITUserService;
import com.cloud.vblog.common.dto.auth.RoleDto;
import com.cloud.vblog.common.dto.auth.UserRoleInfoDto;
import com.cloud.vblog.common.exception.ServiceException;
import com.cloud.vblog.common.utils.JsonUtils;
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
 *  服务实现类
 * </p>
 *
 * @author aiwei
 * @since 2020-04-02
 */
@Service
public class TRoleServiceImpl extends ServiceImpl<TRoleMapper, TRole> implements ITRoleService {

	@Autowired
	private ITUserRoleService userRoleService;
	@Autowired
	private ITUserService userService;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void addRole(RoleDto role) {
		List<TRole> roleList = this.list(new QueryWrapper<TRole>().eq("role_name", role.getRoleName()));
		if (CollectionUtils.isNotEmpty(roleList)){
			throw new ServiceException("角色名已经存在");
		}
		TRole tRole = new TRole();
		tRole.setUid(UUIDUtils.genUid());
		tRole.setRoleName(role.getRoleName());
		tRole.setCreateTime(new Date());
		if (StringUtils.isNotBlank(role.getSummary())){
			tRole.setSummary(role.getSummary());
		}
		tRole.setStatus(role.getStatus());
		if (CollectionUtils.isNotEmpty(role.getCategoryMenuUids())){
			String categoryMenuUidsJstr = JsonUtils.objectToJson(role.getCategoryMenuUids());
			tRole.setCategoryMenuUids(categoryMenuUidsJstr);
		}
		this.save(tRole);
		this.saveUserRole(role,tRole.getUid());
	}

	private void saveUserRole(RoleDto role, String roleId) {
		if (CollectionUtils.isEmpty(role.getUserRoleInfoDtoList())){
			return;
		}
		List<String> userIdList = role.getUserRoleInfoDtoList().stream().map(e -> e.getUserId()).collect(Collectors.toList());
		Collection<TUser> userCollection = userService.listByIds(userIdList);
		List<TUserRole> insertList = new ArrayList<>();
		userCollection.forEach(user ->{
			TUserRole tUserRole = new TUserRole();
			tUserRole.setUid(UUIDUtils.genUid());
			tUserRole.setUserId(user.getUid());
			tUserRole.setRoleId(roleId);
			insertList.add(tUserRole);
		});
		if (CollectionUtils.isNotEmpty(insertList)){
			userRoleService.saveBatch(insertList);
		}
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void editRole(RoleDto role) {
		TRole tRole = this.getById(role.getUid());
		if (null == tRole){
			throw new ServiceException("修改失败,角色不存在");
		}
		if (!tRole.getRoleName().equals(role.getRoleName())){
			List<TRole> tRoleList = this.list(new QueryWrapper<TRole>().eq("role_name", role.getRoleName()));
			if (CollectionUtils.isNotEmpty(tRoleList)){
				throw new ServiceException("角色名已经存在");
			}
		}
		tRole.setUpdateTime(new Date());
		tRole.setSummary(StringUtils.isNotBlank(role.getSummary())?role.getSummary():null);
		tRole.setStatus(role.getStatus());
		if (CollectionUtils.isNotEmpty(role.getCategoryMenuUids())){
			String categoryMenuUidsJstr = JsonUtils.objectToJson(role.getCategoryMenuUids());
			tRole.setCategoryMenuUids(categoryMenuUidsJstr);
		}
		this.updateById(tRole);
		userRoleService.remove(new QueryWrapper<TUserRole>().eq("role_id",tRole.getUid()));
		this.saveUserRole(role,tRole.getUid());
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void delRole(String uid) {
		TRole tRole = this.getById(uid);
		if (null == tRole){
			throw new ServiceException("角色不存在");
		}
		List<TUserRole> userRoleList = userRoleService.list(new QueryWrapper<TUserRole>().eq("role_id", uid));
		if (CollectionUtils.isNotEmpty(userRoleList)){
			throw new ServiceException("当前角色下存在用户，请先删除用户");
		}
		this.removeById(uid);
	}

	@Override
	public List<UserRoleInfoDto> getRoleUserList(String roleId) {
		List<UserRoleInfoDto> userRoleInfoDtoList = new ArrayList<>();
		List<TUserRole> userRoleList = userRoleService.list(new QueryWrapper<TUserRole>().eq("role_id", roleId));
		if (CollectionUtils.isNotEmpty(userRoleList)){
			List<String> userIdList = userRoleList.stream().map(e -> e.getUserId()).collect(Collectors.toList());
			Collection<TUser> userCollection = userService.listByIds(userIdList);
			userCollection.forEach(user ->{
				userRoleInfoDtoList.add(new UserRoleInfoDto(roleId,user.getUid(),user.getUserName()));
			});
		}
		return userRoleInfoDtoList;
	}

	@Override
	public List<RoleDto> queryRoleByName(String name) {
		List<RoleDto> resultList = new ArrayList<>();
		List<TRole> roleList = this.list(StringUtils.isBlank(name) ? new QueryWrapper<>() : new QueryWrapper<TRole>().eq("role_name", name));
		roleList.forEach(role ->{
			RoleDto roleDto = new RoleDto();
			BeanUtils.copyProperties(role,roleDto);
			if (StringUtils.isNotBlank(role.getCategoryMenuUids())){
				roleDto.setCategoryMenuUids(JsonUtils.jsonToList(role.getCategoryMenuUids(),String.class));
			}
			List<UserRoleInfoDto> roleUserList = this.getRoleUserList(role.getUid());
			roleDto.setUserRoleInfoDtoList(roleUserList);
			resultList.add(roleDto);
		});
		return resultList;
	}

	@Override
	public RoleDto queryRoleById(String uid) {
		TRole tRole = this.getById(uid);
		RoleDto roleDto = new RoleDto();
		if (null != tRole){
			BeanUtils.copyProperties(tRole,roleDto);
			if (StringUtils.isNotBlank(tRole.getCategoryMenuUids())){
				roleDto.setCategoryMenuUids(JsonUtils.jsonToList(tRole.getCategoryMenuUids(),String.class));
			}
			List<UserRoleInfoDto> roleUserList = this.getRoleUserList(uid);
			roleDto.setUserRoleInfoDtoList(roleUserList);
		}
		return roleDto;
	}

}
