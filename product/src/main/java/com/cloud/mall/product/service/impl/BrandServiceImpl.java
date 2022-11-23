package com.cloud.mall.product.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.mall.common.utils.PageUtils;
import com.cloud.mall.common.utils.Query;
import com.cloud.mall.product.dao.BrandDao;
import com.cloud.mall.product.entity.BrandEntity;
import com.cloud.mall.product.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String key = (String) params.get("key");
        QueryWrapper<BrandEntity> queryWrapper = new QueryWrapper<>();
        if (StrUtil.isNotBlank(key)) {
            queryWrapper.lambda().eq(BrandEntity::getBrandId, key)
                    .or().like(BrandEntity::getName, key);
        }
        IPage<BrandEntity> page = this.page(
                new Query<BrandEntity>().getPage(params),
                queryWrapper.lambda().orderByAsc(BrandEntity::getSort));

        return new PageUtils(page);
    }

}