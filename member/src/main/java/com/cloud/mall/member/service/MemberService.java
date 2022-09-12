package com.cloud.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.mall.common.utils.PageUtils;
import com.cloud.mall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author scl
 * @email sclll
 * @date 2022-09-12 16:44:33
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

