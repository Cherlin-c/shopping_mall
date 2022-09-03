package com.cloud.mall.product.service.impl;

import com.cloud.mall.product.entity.Category;
import com.cloud.mall.product.mapper.CategoryMapper;
import com.cloud.mall.product.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品三级分类 服务实现类
 * </p>
 *
 * @author scl
 * @since 2022-09-04
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
