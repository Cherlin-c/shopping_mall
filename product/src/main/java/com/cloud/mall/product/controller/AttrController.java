package com.cloud.mall.product.controller;

import com.cloud.mall.common.utils.PageUtils;
import com.cloud.mall.common.utils.R;
import com.cloud.mall.product.entity.AttrEntity;
import com.cloud.mall.product.service.AttrService;
import com.cloud.mall.product.vo.AttrRespVO;
import com.cloud.mall.product.vo.AttrVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 商品属性
 *
 * @author scl
 * @email sclll
 * @date 2022-09-05 21:37:21
 */
@RestController
@RequestMapping("product/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = attrService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/{attrType}/list/{catelogId}")
    public R baseList(@PathVariable("catelogId") Long catelogId, @RequestParam Map<String, Object> params,@PathVariable("attrType")String type) {
        PageUtils page = attrService.queryPage(catelogId,params,type);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    public R info(@PathVariable("attrId") Long attrId) {
//        AttrEntity attr = attrService.getById(attrId);
        AttrRespVO respVO = attrService.getAttrInfo(attrId);
        return R.ok().put("attr", respVO);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AttrVO attr) {
        attrService.saveAttr(attr);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody AttrVO attr) {
        attrService.updateAttr(attr);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] attrIds) {
        attrService.removeByIds(Arrays.asList(attrIds));

        return R.ok();
    }

}
