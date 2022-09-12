package com.cloud.mall.coupon.dao;

import com.cloud.mall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author scl
 * @email sclll
 * @date 2022-09-12 17:10:12
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
