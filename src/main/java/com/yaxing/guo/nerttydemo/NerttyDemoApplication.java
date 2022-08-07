package com.yaxing.guo.nerttydemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper")
public class NerttyDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NerttyDemoApplication.class, args);
    }

}
