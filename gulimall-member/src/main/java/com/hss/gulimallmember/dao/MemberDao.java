package com.hss.gulimallmember.dao;

import com.hss.gulimallmember.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author huangshuaishuai
 * @email sunlightcs@gmail.com
 * @date 2022-06-15 09:23:00
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
