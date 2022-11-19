package com.cloud.mall.thirdpart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.cloud.mall.thirdpart.file.dao")
@SpringBootApplication
public class ThirdPartApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThirdPartApplication.class, args);
    }

}