package com.yaxing.guo.nerttydemo.servive;

import com.yaxing.guo.nerttydemo.req.UserLoginReq;
import com.yaxing.guo.nerttydemo.req.UserSaveReq;
import com.yaxing.guo.nerttydemo.resp.UserLoginResp;

public interface LoginService {
    void register(UserSaveReq req);

    UserLoginResp login(UserLoginReq req);
}
