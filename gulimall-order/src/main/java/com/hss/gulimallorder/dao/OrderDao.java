package com.hss.gulimallorder.dao;

import com.hss.gulimallorder.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author huangshuaishuai
 * @email sunlightcs@gmail.com
 * @date 2022-06-15 09:03:56
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
