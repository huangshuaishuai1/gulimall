package com.hss.gulimallproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hss.common.utils.PageUtils;
import com.hss.gulimallproduct.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author huangshuaishuai
 * @email sunlightcs@gmail.com
 * @date 2022-06-14 13:01:10
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void updateWithAll(BrandEntity brand);
}

