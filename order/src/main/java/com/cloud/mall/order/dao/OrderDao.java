package com.cloud.mall.order.dao;

import com.cloud.mall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author scl
 * @email sclll
 * @date 2022-09-12 16:58:45
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
