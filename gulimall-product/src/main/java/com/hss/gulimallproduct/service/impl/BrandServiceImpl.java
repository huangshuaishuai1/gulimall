package com.hss.gulimallproduct.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hss.gulimallproduct.entity.CategoryBrandRelationEntity;
import com.hss.gulimallproduct.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hss.common.utils.PageUtils;
import com.hss.common.utils.Query;

import com.hss.gulimallproduct.dao.BrandDao;
import com.hss.gulimallproduct.entity.BrandEntity;
import com.hss.gulimallproduct.service.BrandService;
import org.springframework.util.StringUtils;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

    @Autowired
    CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        //1、获取key
        String key = (String) params.get("key");
        QueryWrapper<BrandEntity> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(key)) {
            queryWrapper.eq("brand_id",key).or().like("name",key);
        }
        IPage<BrandEntity> page = this.page(
                new Query<BrandEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

    @Override
    public void updateWithAll(BrandEntity brand) {
        this.updateById(brand);
        String name = brand.getName();
        if (!StringUtils.isEmpty(name)) {
            categoryBrandRelationService.updateCategoryBrandRelationFromBrand(brand.getBrandId(),name);
        }



    }

}