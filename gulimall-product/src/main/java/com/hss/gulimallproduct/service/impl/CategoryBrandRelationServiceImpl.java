package com.hss.gulimallproduct.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hss.common.utils.PageUtils;
import com.hss.common.utils.Query;

import com.hss.gulimallproduct.dao.CategoryBrandRelationDao;
import com.hss.gulimallproduct.entity.CategoryBrandRelationEntity;
import com.hss.gulimallproduct.service.CategoryBrandRelationService;


@Service("categoryBrandRelationService")
public class CategoryBrandRelationServiceImpl extends ServiceImpl<CategoryBrandRelationDao, CategoryBrandRelationEntity> implements CategoryBrandRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryBrandRelationEntity> page = this.page(
                new Query<CategoryBrandRelationEntity>().getPage(params),
                new QueryWrapper<CategoryBrandRelationEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long brandId) {
        QueryWrapper<CategoryBrandRelationEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("brand_id",brandId);
        IPage<CategoryBrandRelationEntity> page = this.page(
                new Query<CategoryBrandRelationEntity>().getPage(params),
                wrapper
        );
        return new PageUtils(page);
    }

    @Override
    public void updateCategoryBrandRelationFromCategory(Long catId, String name) {
        UpdateWrapper<CategoryBrandRelationEntity> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("catelog_id",catId);
        updateWrapper.set("catelog_name",name);
        this.update(updateWrapper);
    }

    @Override
    public void updateCategoryBrandRelationFromBrand(Long brandId, String name) {
        UpdateWrapper<CategoryBrandRelationEntity> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("brand_id",brandId);
        updateWrapper.set("brand_name",name);
        this.update(updateWrapper);
    }
}