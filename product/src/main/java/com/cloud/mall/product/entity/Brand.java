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
 * 品牌
 * </p>
 *
 * @author scl
 * @since 2022-09-04
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("pms_brand")
@ApiModel(value = "Brand对象", description = "品牌")
public class Brand implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("品牌id")
    @TableId(value = "brand_id", type = IdType.AUTO)
    private Long brandId;

    @ApiModelProperty("品牌名")
    @TableField("name")
    private String name;

    @ApiModelProperty("品牌logo地址")
    @TableField("logo")
    private String logo;

    @ApiModelProperty("介绍")
    @TableField("descript")
    private String descript;

    @ApiModelProperty("显示状态[0-不显示；1-显示]")
    @TableField("show_status")
    private Integer showStatus;

    @ApiModelProperty("检索首字母")
    @TableField("first_letter")
    private String firstLetter;

    @ApiModelProperty("排序")
    @TableField("sort")
    private Integer sort;


}
