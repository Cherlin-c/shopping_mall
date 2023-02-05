package com.cloud.mall.product.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.lang.tree.parser.DefaultNodeParser;
import cn.hutool.core.util.ArrayUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.mall.common.utils.PageUtils;
import com.cloud.mall.common.utils.Query;
import com.cloud.mall.product.dao.CategoryDao;
import com.cloud.mall.product.entity.CategoryEntity;
import com.cloud.mall.product.service.CategoryBrandRelationService;
import com.cloud.mall.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {
    @Autowired
    CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<Tree<Long>> tree() {
        List<CategoryEntity> list = this.list();
        // 构建node列表
        List<TreeNode<Long>> nodeList = CollUtil.newArrayList();
        for (CategoryEntity categoryEntity : list) {
            HashMap<String, Object> extraMap = new HashMap<>();
            extraMap.put(CategoryEntity.Fields.icon, categoryEntity.getIcon());
            extraMap.put(CategoryEntity.Fields.catLevel, categoryEntity.getCatLevel());
            extraMap.put(CategoryEntity.Fields.productCount, categoryEntity.getProductCount());
            extraMap.put(CategoryEntity.Fields.productUnit, categoryEntity.getProductUnit());
            extraMap.put(CategoryEntity.Fields.showStatus, categoryEntity.getShowStatus());
            nodeList.add(new TreeNode<>
                    (categoryEntity.getCatId(), categoryEntity.getParentCid(), categoryEntity.getName(), categoryEntity.getSort())
                    .setExtra(extraMap));
        }
        TreeNodeConfig nodeConfig = new TreeNodeConfig();
        nodeConfig.setIdKey(CategoryEntity.Fields.catId);
        nodeConfig.setParentIdKey(CategoryEntity.Fields.parentCid);
        nodeConfig.setWeightKey(CategoryEntity.Fields.sort);
        return TreeUtil.build(nodeList, 0L, nodeConfig, new DefaultNodeParser<>());
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
        //TODO 1.检查当前删除的菜单,是否被别的地方引用
        baseMapper.deleteBatchIds(asList);
    }

    @Override
    public Long[] getFullPath(Long catelogId) {
        ArrayList<Long> path = new ArrayList<>();
        findFullPath(catelogId,path);
        return ArrayUtil.toArray(CollUtil.reverse(path),Long.class);
    }

    /**
     * 级联更新所有关联的数据
     * @param category
     */
    @Override
    public void updateCascade(CategoryEntity category) {
        this.updateById(category);
        categoryBrandRelationService.updateCategory(category.getCatId(),category.getName());
    }

    private void findFullPath(Long catelogId,ArrayList<Long> path){
        path.add(catelogId);
        CategoryEntity categoryEntity = this.getById(catelogId);
        if (categoryEntity.getParentCid()!=0){
            findFullPath(categoryEntity.getParentCid(),path);
        }
    }

}