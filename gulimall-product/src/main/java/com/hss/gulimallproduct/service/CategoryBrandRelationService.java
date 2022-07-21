package com.hss.gulimallproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hss.common.utils.PageUtils;
import com.hss.gulimallproduct.entity.CategoryBrandRelationEntity;

import java.util.Map;

/**
 * 品牌分类关联
 *
 * @author huangshuaishuai
 * @email sunlightcs@gmail.com
 * @date 2022-06-14 13:01:10
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPage(Map<String, Object> params, Long brandId);
    
    void updateCategoryBrandRelationFromCategory(Long catId, String name);

    void updateCategoryBrandRelationFromBrand(Long brandId, String name);
}

