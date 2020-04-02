package com.cloud.vblog.auth.service.impl;

import com.cloud.vblog.auth.entity.TUser;
import com.cloud.vblog.auth.mapper.TUserMapper;
import com.cloud.vblog.auth.service.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
