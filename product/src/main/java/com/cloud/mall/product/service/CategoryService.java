package com.cloud.mall.product.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.mall.common.utils.PageUtils;
import com.cloud.mall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author scl
 * @email sclll
 * @date 2022-09-05 21:37:19
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<Tree<Long>> tree();

    void removeMenuByIds(List<Long> asList);

    Long[] getFullPath(Long catelogId);
}

