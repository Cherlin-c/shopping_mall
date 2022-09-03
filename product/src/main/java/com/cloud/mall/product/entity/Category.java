package com.cloud.mall.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品三级分类
 * </p>
 *
 * @author scl
 * @since 2022-09-04
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("pms_category")
@ApiModel(value = "Category对象", description = "商品三级分类")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("分类id")
    @TableId(value = "cat_id", type = IdType.AUTO)
    private Long catId;

    @ApiModelProperty("分类名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("父分类id")
    @TableField("parent_cid")
    private Long parentCid;

    @ApiModelProperty("层级")
    @TableField("cat_level")
    private Integer catLevel;

    @ApiModelProperty("是否显示[0-不显示，1显示]")
    @TableField("show_status")
    private Integer showStatus;

    @ApiModelProperty("排序")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty("图标地址")
    @TableField("icon")
    private String icon;

    @ApiModelProperty("计量单位")
    @TableField("product_unit")
    private String productUnit;

    @ApiModelProperty("商品数量")
    @TableField("product_count")
    private Integer productCount;


}
