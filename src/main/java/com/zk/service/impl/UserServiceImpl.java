package com.zk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zk.entity.UserEntity;
import com.zk.mapper.UserMapper;
import com.zk.service.IUserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements IUserService {
}
