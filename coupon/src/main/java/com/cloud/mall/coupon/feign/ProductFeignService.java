package com.cloud.mall.coupon.feign;

import com.cloud.mall.common.utils.PageUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 产品
 *
 * @author : scl
 * @date :  2022/9/10
 */
@FeignClient("cloud-product")
public interface ProductFeignService {


    @RequestMapping("/product/brand/list")
    PageUtils list();
}