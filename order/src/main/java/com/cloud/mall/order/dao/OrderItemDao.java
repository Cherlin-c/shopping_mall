package com.cloud.mall.order.dao;

import com.cloud.mall.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author scl
 * @email sclll
 * @date 2022-09-12 16:58:44
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
