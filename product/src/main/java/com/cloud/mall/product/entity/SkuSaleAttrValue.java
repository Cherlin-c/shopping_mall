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
 * sku销售属性&值
 * </p>
 *
 * @author scl
 * @since 2022-09-04
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("pms_sku_sale_attr_value")
@ApiModel(value = "SkuSaleAttrValue对象", description = "sku销售属性&值")
public class SkuSaleAttrValue implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("sku_id")
    @TableField("sku_id")
    private Long skuId;

    @ApiModelProperty("attr_id")
    @TableField("attr_id")
    private Long attrId;

    @ApiModelProperty("销售属性名")
    @TableField("attr_name")
    private String attrName;

    @ApiModelProperty("销售属性值")
    @TableField("attr_value")
    private String attrValue;

    @ApiModelProperty("顺序")
    @TableField("attr_sort")
    private Integer attrSort;


}
