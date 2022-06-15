package com.hss.gulimallware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hss.common.utils.PageUtils;
import com.hss.gulimallware.entity.WareOrderTaskDetailEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author huangshuaishuai
 * @email sunlightcs@gmail.com
 * @date 2022-06-15 09:32:09
 */
public interface WareOrderTaskDetailService extends IService<WareOrderTaskDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

