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
 * sku图片
 * </p>
 *
 * @author scl
 * @since 2022-09-04
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("pms_sku_images")
@ApiModel(value = "SkuImages对象", description = "sku图片")
public class SkuImages implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("sku_id")
    @TableField("sku_id")
    private Long skuId;

    @ApiModelProperty("图片地址")
    @TableField("img_url")
    private String imgUrl;

    @ApiModelProperty("排序")
    @TableField("img_sort")
    private Integer imgSort;

    @ApiModelProperty("默认图[0 - 不是默认图，1 - 是默认图]")
    @TableField("default_img")
    private Integer defaultImg;


}
