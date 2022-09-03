package com.cloud.mall.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * spu信息
 * </p>
 *
 * @author scl
 * @since 2022-09-04
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("pms_spu_info")
@ApiModel(value = "SpuInfo对象", description = "spu信息")
public class SpuInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("商品名称")
    @TableField("spu_name")
    private String spuName;

    @ApiModelProperty("商品描述")
    @TableField("spu_description")
    private String spuDescription;

    @ApiModelProperty("所属分类id")
    @TableField("catalog_id")
    private Long catalogId;

    @ApiModelProperty("品牌id")
    @TableField("brand_id")
    private Long brandId;

    @TableField("weight")
    private BigDecimal weight;

    @ApiModelProperty("上架状态[0 - 下架，1 - 上架]")
    @TableField("publish_status")
    private Integer publishStatus;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;


}
