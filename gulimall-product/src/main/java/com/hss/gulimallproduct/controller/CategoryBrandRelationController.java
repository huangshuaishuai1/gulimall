package com.hss.gulimallproduct.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hss.common.utils.PageUtils;
import com.hss.common.utils.R;
import com.hss.gulimallproduct.entity.CategoryBrandRelationEntity;
import com.hss.gulimallproduct.service.BrandService;
import com.hss.gulimallproduct.service.CategoryBrandRelationService;
import com.hss.gulimallproduct.service.CategoryService;
import com.hss.gulimallproduct.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 品牌分类关联
 *
 * @author huangshuaishuai
 * @email sunlightcs@gmail.com
 * @date 2022-06-14 13:32:53
 */
@RestController
@RequestMapping("gulimallproduct/categorybrandrelation")
public class CategoryBrandRelationController {
    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    BrandService brandService;

    @GetMapping("/brands/list")
    public R getBrandsList(@RequestParam Long catId){
        QueryWrapper<CategoryBrandRelationEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("catelog_id",catId);
        List<CategoryBrandRelationEntity> data = categoryBrandRelationService.list(wrapper);

        return R.ok().put("data", data);
    }

    @GetMapping("/catelog/list")
    public R getCatelogList(@RequestParam Long brandId){
        QueryWrapper<CategoryBrandRelationEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("brand_id",brandId);
        List<CategoryBrandRelationEntity> data = categoryBrandRelationService.list(wrapper);

        return R.ok().put("data", data);
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryBrandRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		CategoryBrandRelationEntity categoryBrandRelation = categoryBrandRelationService.getById(id);

        return R.ok().put("categoryBrandRelation", categoryBrandRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CategoryBrandRelationEntity categoryBrandRelation){
        Long brandId = categoryBrandRelation.getBrandId();
        Long catelogId = categoryBrandRelation.getCatelogId();
        String catName = categoryService.getById(catelogId).getName();
        categoryBrandRelation.setCatelogName(catName);
        String brandName = brandService.getById(brandId).getName();
        categoryBrandRelation.setBrandName(brandName);
        categoryBrandRelationService.save(categoryBrandRelation);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CategoryBrandRelationEntity categoryBrandRelation){
		categoryBrandRelationService.updateById(categoryBrandRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		categoryBrandRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
