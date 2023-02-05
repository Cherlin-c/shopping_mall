package com.cloud.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.mall.common.utils.PageUtils;
import com.cloud.mall.product.entity.AttrEntity;
import com.cloud.mall.product.vo.AttrRespVO;
import com.cloud.mall.product.vo.AttrVO;

import java.util.Map;

/**
 * 商品属性
 *
 * @author scl
 * @email sclll
 * @date 2022-09-05 21:37:21
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPage(Long catelogId, Map<String, Object> params);

    void saveAttr(AttrVO attr);

    AttrRespVO getAttrInfo(Long attrId);

    void updateAttr(AttrVO attr);
}

