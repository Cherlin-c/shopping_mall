package com.cloud.mall.order.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("cloud-ware")
public interface WareFeignService {
}
