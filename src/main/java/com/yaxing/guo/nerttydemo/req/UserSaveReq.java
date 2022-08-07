package com.yaxing.guo.nerttydemo.req;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
public class UserSaveReq {
    private Long id;
    private String username;
    private String password;
}
