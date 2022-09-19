package com.cloud.mall.coupon.controller;

import com.cloud.mall.common.utils.PageUtils;
import com.cloud.mall.common.utils.R;
import com.cloud.mall.coupon.feign.ProductFeignService;
import com.cloud.mall.coupon.feign.WareFeignService;
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
    @Autowired
    private WareFeignService wareFeignService;

    /**
     * 列表
     */
    @RequestMapping("/product/brand/list")
    public R list() {
        PageUtils page = productFeignService.list();
        return R.ok().put("page", page);
    }

    /**
     * 优惠库存信息
     */
    @RequestMapping("/ware/wareinfo/info")
    public R listWareInfo() {
        R page = wareFeignService.listWareInfo(1L);
        return R.ok().put("page", page);
    }

}