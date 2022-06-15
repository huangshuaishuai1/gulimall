package com.hss.gulimallproduct.dao;

import com.hss.gulimallproduct.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author huangshuaishuai
 * @email sunlightcs@gmail.com
 * @date 2022-06-14 13:01:10
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
