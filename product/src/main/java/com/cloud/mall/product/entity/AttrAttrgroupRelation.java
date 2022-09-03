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
 * 属性&属性分组关联
 * </p>
 *
 * @author scl
 * @since 2022-09-04
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("pms_attr_attrgroup_relation")
@ApiModel(value = "AttrAttrgroupRelation对象", description = "属性&属性分组关联")
public class AttrAttrgroupRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("属性id")
    @TableField("attr_id")
    private Long attrId;

    @ApiModelProperty("属性分组id")
    @TableField("attr_group_id")
    private Long attrGroupId;

    @ApiModelProperty("属性组内排序")
    @TableField("attr_sort")
    private Integer attrSort;


}
