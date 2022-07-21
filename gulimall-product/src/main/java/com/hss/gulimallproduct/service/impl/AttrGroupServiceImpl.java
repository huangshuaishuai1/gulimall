package com.hss.gulimallproduct.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hss.common.utils.PageUtils;
import com.hss.common.utils.Query;

import com.hss.gulimallproduct.dao.AttrGroupDao;
import com.hss.gulimallproduct.entity.AttrGroupEntity;
import com.hss.gulimallproduct.service.AttrGroupService;
import org.springframework.util.StringUtils;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long catelogId) {
        if (catelogId == 0) {
            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params),
                    new QueryWrapper<AttrGroupEntity>());
            return new PageUtils(page);
        }else {
            String key = (String) params.get("key");
            QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<AttrGroupEntity>().eq("catelog_id",catelogId);
            if (!StringUtils.isEmpty(key)) {
                wrapper.and((obj)->{
                    obj.eq("attr_group_id",key).or().like("attr_group_name",key);
                });
            }
            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params),
                    wrapper);
            System.out.println(wrapper);
            return new PageUtils(page);
        }
//        QueryWrapper<AttrGroupEntity> queryWrapper = new QueryWrapper<>();
//        String key = (String)params.get("key");
//        if(!StringUtils.isEmpty(key)){
//            queryWrapper.eq("attr_group_id",key).or().like("attr_group_name",key);
//        }
//        if(catelogId == 0){
//            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params),
//                    queryWrapper);
//            return new PageUtils(page);
//        }else{
//            queryWrapper.eq("catelog_id",catelogId);
//            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params),queryWrapper);
//            return new PageUtils(page);
//        }
    }

    @Override
    public AttrGroupEntity getByIdd(Long catelogId) {
        QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("attr_group_id",catelogId);
        List<AttrGroupEntity> list = this.list(wrapper);
        return list.get(0);
    }

}