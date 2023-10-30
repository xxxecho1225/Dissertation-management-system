package com.zk.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zk.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

}
