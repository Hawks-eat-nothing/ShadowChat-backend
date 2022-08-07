package com.yaxing.guo.nerttydemo.controller;

import com.yaxing.guo.nerttydemo.req.UserLoginReq;
import com.yaxing.guo.nerttydemo.req.UserSaveReq;
import com.yaxing.guo.nerttydemo.resp.CommonResp;
import com.yaxing.guo.nerttydemo.resp.UserLoginResp;
import com.yaxing.guo.nerttydemo.servive.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yaxing_Guo
 */
@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/register")
    public CommonResp register(@RequestBody UserSaveReq req){
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        CommonResp<Object> resp = new CommonResp<>();
        loginService.register(req);
        return resp;
    }
    @PostMapping("/login")
    public CommonResp login(@RequestBody UserLoginReq req){
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        CommonResp resp = new CommonResp<>();
        UserLoginResp userLoginResp = loginService.login(req);
        resp.setContent(userLoginResp);
        return resp;
    }



}
