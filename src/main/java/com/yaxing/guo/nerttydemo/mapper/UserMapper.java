package com.yaxing.guo.nerttydemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yaxing.guo.nerttydemo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
}

