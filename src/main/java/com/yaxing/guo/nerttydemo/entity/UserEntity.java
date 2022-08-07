package com.yaxing.guo.nerttydemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_info")
public class UserEntity {
    private Long id;
    private String username;
    private String password;
}
