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
 * spu图片
 * </p>
 *
 * @author scl
 * @since 2022-09-04
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("pms_spu_images")
@ApiModel(value = "SpuImages对象", description = "spu图片")
public class SpuImages implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("spu_id")
    @TableField("spu_id")
    private Long spuId;

    @ApiModelProperty("图片名")
    @TableField("img_name")
    private String imgName;

    @ApiModelProperty("图片地址")
    @TableField("img_url")
    private String imgUrl;

    @ApiModelProperty("顺序")
    @TableField("img_sort")
    private Integer imgSort;

    @ApiModelProperty("是否默认图")
    @TableField("default_img")
    private Integer defaultImg;


}
