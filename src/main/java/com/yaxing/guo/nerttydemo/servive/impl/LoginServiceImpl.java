package com.yaxing.guo.nerttydemo.servive.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yaxing.guo.nerttydemo.entity.UserEntity;
import com.yaxing.guo.nerttydemo.mapper.UserMapper;
import com.yaxing.guo.nerttydemo.req.UserLoginReq;
import com.yaxing.guo.nerttydemo.req.UserSaveReq;
import com.yaxing.guo.nerttydemo.resp.UserLoginResp;
import com.yaxing.guo.nerttydemo.servive.LoginService;
import com.yaxing.guo.nerttydemo.utils.CopyUtil;
import com.yaxing.guo.nerttydemo.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.Collection;
import java.util.List;

/**
 * @author Yaxing_Guo
 */
@Service
public class LoginServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SnowFlake snowFlake;

    @Override
    public void register(UserSaveReq req) {
        UserEntity user = CopyUtil.copy(req, UserEntity.class);
        if (ObjectUtils.isEmpty(req.getId())){
            UserEntity userDb = selectByUsername(req.getUsername());
            if (ObjectUtils.isEmpty(userDb)){
                user.setId(snowFlake.nextId());
                userMapper.insert(user);
            }
        }
    }

    @Override
    public UserLoginResp login(UserLoginReq req) {
        UserEntity userDb = selectByUsername(req.getUsername());
        if (ObjectUtils.isEmpty(userDb)){
            //用户名不存在
            return null;
        }else {
            //登录成功
            if (req.getPassword().equals(userDb.getPassword())){
                UserLoginResp userLoginResp = CopyUtil.copy(userDb, UserLoginResp.class);
                return userLoginResp;
            }else {
                return null;
            }
        }
    }

    //查询用户名是否被注册
    public UserEntity selectByUsername(String username){
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(UserEntity::getId,username);
        List<UserEntity> userEntityList = userMapper.selectList(wrapper);
        if (CollectionUtils.isEmpty(userEntityList)){
            return null;
        }else {
            return userEntityList.get(0);
        }
    }
}
