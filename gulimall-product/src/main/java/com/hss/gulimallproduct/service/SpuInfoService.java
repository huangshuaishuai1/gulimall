package com.hss.gulimallproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hss.common.utils.PageUtils;
import com.hss.gulimallproduct.entity.SpuInfoEntity;

import java.util.Map;

/**
 * spu信息
 *
 * @author huangshuaishuai
 * @email sunlightcs@gmail.com
 * @date 2022-06-14 13:01:10
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

