package com.cloud.mall.product.dao;

import com.cloud.mall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author scl
 * @email sclll
 * @date 2022-09-05 21:37:19
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
