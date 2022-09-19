package com.cloud.mall.coupon.feign;

import com.cloud.mall.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("cloud-ware")
public interface WareFeignService {
    @RequestMapping("/ware/wareinfo/info/{id}")
    public R listWareInfo(@PathVariable("id") Long id);
}
