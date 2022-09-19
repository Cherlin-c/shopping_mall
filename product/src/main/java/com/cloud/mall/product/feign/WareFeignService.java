package com.cloud.mall.product.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("cloud-ware")
public interface WareFeignService {
}
