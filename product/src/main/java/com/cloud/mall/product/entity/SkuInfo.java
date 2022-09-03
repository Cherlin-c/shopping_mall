package com.cloud.mall.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * sku信息
 * </p>
 *
 * @author scl
 * @since 2022-09-04
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("pms_sku_info")
@ApiModel(value = "SkuInfo对象", description = "sku信息")
public class SkuInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("skuId")
    @TableId(value = "sku_id", type = IdType.AUTO)
    private Long skuId;

    @ApiModelProperty("spuId")
    @TableField("spu_id")
    private Long spuId;

    @ApiModelProperty("sku名称")
    @TableField("sku_name")
    private String skuName;

    @ApiModelProperty("sku介绍描述")
    @TableField("sku_desc")
    private String skuDesc;

    @ApiModelProperty("所属分类id")
    @TableField("catalog_id")
    private Long catalogId;

    @ApiModelProperty("品牌id")
    @TableField("brand_id")
    private Long brandId;

    @ApiModelProperty("默认图片")
    @TableField("sku_default_img")
    private String skuDefaultImg;

    @ApiModelProperty("标题")
    @TableField("sku_title")
    private String skuTitle;

    @ApiModelProperty("副标题")
    @TableField("sku_subtitle")
    private String skuSubtitle;

    @ApiModelProperty("价格")
    @TableField("price")
    private BigDecimal price;

    @ApiModelProperty("销量")
    @TableField("sale_count")
    private Long saleCount;


}
