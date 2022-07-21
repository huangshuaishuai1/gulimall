package com.hss.gulimallproduct.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hss.gulimallproduct.entity.CategoryBrandRelationEntity;
import com.hss.gulimallproduct.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hss.common.utils.PageUtils;
import com.hss.common.utils.Query;

import com.hss.gulimallproduct.dao.CategoryDao;
import com.hss.gulimallproduct.entity.CategoryEntity;
import com.hss.gulimallproduct.service.CategoryService;
import org.springframework.util.StringUtils;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

//    @Autowired
//    CategoryDao categoryDao;

    @Autowired
    CategoryBrandRelationService categoryBrandRelationService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        //查出所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);
        //2组装成父子的树形结构
        //2.1 找到所有的一级分类
        List<CategoryEntity> level1Menus = entities.stream().filter((categoryEntity) -> {
            return categoryEntity.getParentCid() == 0;
        }).map((menu)->{
            menu.setChildren(getChildren(menu,entities));
            return menu;
        }).sorted((menu1,menu2)->{
            return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());
        }).collect(Collectors.toList());
        return level1Menus;
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
        //TODO 1. 检查当前删除的菜单是否被别的地方引用
        baseMapper.deleteBatchIds(asList);
    }

    @Override
    public Long[] getCatelogPath(Long catelogId) {
        ArrayList<Long> paths = new ArrayList<Long>();
        findParentPath(catelogId, paths);
        Long[] ret = paths.toArray(new Long[0]);
        return ret;

    }

    @Override
    public void updateWithAll(CategoryEntity category) {
        this.updateById(category);
        String name = category.getName();
        if (!StringUtils.isEmpty(name)){
            categoryBrandRelationService.updateCategoryBrandRelationFromCategory(category.getCatId(),name);
        }
    }

    private void findParentPath(Long catelogId,ArrayList<Long> paths) {
        paths.add(0,catelogId);
        CategoryEntity byId = this.getById(catelogId);
        if (byId.getParentCid()!=0) {
            findParentPath(byId.getParentCid(),paths);

        }
    }
     //递归查找所有菜单的子菜单
    private List<CategoryEntity> getChildren(CategoryEntity root,List<CategoryEntity> all) {
        List<CategoryEntity> children = all.stream().filter(categoryEntity -> {
            return categoryEntity.getParentCid().equals(root.getCatId());
        }).map(categoryEntity -> {
            // 找到子菜单
            categoryEntity.setChildren(getChildren(categoryEntity,all));
            return categoryEntity;
        }).sorted((menu1,menu2) ->{
            // 菜单的排序
            return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());
        }).collect(Collectors.toList());
        return children;
    }

}