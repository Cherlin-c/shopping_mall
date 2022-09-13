package com.cloud.mall.coupon.controller;

import com.cloud.mall.common.utils.PageUtils;
import com.cloud.mall.common.utils.R;
import com.cloud.mall.coupon.feign.ProductFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务调用
 *
 * @author : scl
 * @date :  2022/9/10
 */
@RestController
@RequestMapping("/coupon")
public class FeignController {
    @Autowired
    private ProductFeignService productFeignService;

    /**
     * 列表
     */
    @RequestMapping("/product/brand/list")
    public R list() {
        PageUtils page = productFeignService.list();
        return R.ok().put("page", page);
    }


}