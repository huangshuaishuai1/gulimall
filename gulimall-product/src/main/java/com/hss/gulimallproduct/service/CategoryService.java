package com.hss.gulimallproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hss.common.utils.PageUtils;
import com.hss.gulimallproduct.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author huangshuaishuai
 * @email sunlightcs@gmail.com
 * @date 2022-06-14 13:01:10
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTree();
}

