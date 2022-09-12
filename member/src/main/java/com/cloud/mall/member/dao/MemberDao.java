package com.cloud.mall.member.dao;

import com.cloud.mall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author scl
 * @email sclll
 * @date 2022-09-12 16:44:33
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
