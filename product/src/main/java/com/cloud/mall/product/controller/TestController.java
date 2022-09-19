package com.cloud.mall.product.controller;

import com.cloud.mall.common.utils.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试服务
 *
 * @author : scl
 * @date :  2022/9/10
 */
@RefreshScope
@RestController
@RequestMapping("/test")
public class TestController {

    @Value("${config.test.user}")
    private String user;
    @Value("${config.test.age}")
    private String age;

    @GetMapping("/config")
    public R testConfig() {
        return R.ok().put("user", user).put("age", age);
    }
}