package com.hss.gulimallcoupon.dao;

import com.hss.gulimallcoupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author huangshuaishuai
 * @email sunlightcs@gmail.com
 * @date 2022-06-15 09:17:19
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
