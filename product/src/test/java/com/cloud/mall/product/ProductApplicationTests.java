package com.cloud.mall.product;

import com.cloud.mall.product.entity.BrandEntity;
import com.cloud.mall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Test
    void contextLoads() {
        BrandEntity brand = new BrandEntity();
        brand.setName("hahaha");
        brandService.save(brand);
    }
    @Test
    void list() {
        System.out.println("brandService.list() = " + brandService.list());
    }

}
