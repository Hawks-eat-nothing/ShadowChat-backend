package com.yaxing.guo.nerttydemo.resp;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_info")
public class UserLoginResp {
    private Long id;
    private String username;
}
