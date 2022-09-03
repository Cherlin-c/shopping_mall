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
 * 属性分组
 * </p>
 *
 * @author scl
 * @since 2022-09-04
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("pms_attr_group")
@ApiModel(value = "AttrGroup对象", description = "属性分组")
public class AttrGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("分组id")
    @TableId(value = "attr_group_id", type = IdType.AUTO)
    private Long attrGroupId;

    @ApiModelProperty("组名")
    @TableField("attr_group_name")
    private String attrGroupName;

    @ApiModelProperty("排序")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty("描述")
    @TableField("descript")
    private String descript;

    @ApiModelProperty("组图标")
    @TableField("icon")
    private String icon;

    @ApiModelProperty("所属分类id")
    @TableField("catelog_id")
    private Long catelogId;


}
