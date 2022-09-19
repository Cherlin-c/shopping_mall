package com.cloud.mall.member.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("cloud-ware")
public interface WareFeignService {
}
