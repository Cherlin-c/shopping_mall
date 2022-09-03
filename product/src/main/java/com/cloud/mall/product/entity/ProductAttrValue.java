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
 * spu属性值
 * </p>
 *
 * @author scl
 * @since 2022-09-04
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("pms_product_attr_value")
@ApiModel(value = "ProductAttrValue对象", description = "spu属性值")
public class ProductAttrValue implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("商品id")
    @TableField("spu_id")
    private Long spuId;

    @ApiModelProperty("属性id")
    @TableField("attr_id")
    private Long attrId;

    @ApiModelProperty("属性名")
    @TableField("attr_name")
    private String attrName;

    @ApiModelProperty("属性值")
    @TableField("attr_value")
    private String attrValue;

    @ApiModelProperty("顺序")
    @TableField("attr_sort")
    private Integer attrSort;

    @ApiModelProperty("快速展示【是否展示在介绍上；0-否 1-是】")
    @TableField("quick_show")
    private Integer quickShow;


}
