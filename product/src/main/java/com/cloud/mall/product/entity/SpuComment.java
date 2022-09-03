package com.cloud.mall.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品评价
 * </p>
 *
 * @author scl
 * @since 2022-09-04
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("pms_spu_comment")
@ApiModel(value = "SpuComment对象", description = "商品评价")
public class SpuComment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("sku_id")
    @TableField("sku_id")
    private Long skuId;

    @ApiModelProperty("spu_id")
    @TableField("spu_id")
    private Long spuId;

    @ApiModelProperty("商品名字")
    @TableField("spu_name")
    private String spuName;

    @ApiModelProperty("会员昵称")
    @TableField("member_nick_name")
    private String memberNickName;

    @ApiModelProperty("星级")
    @TableField("star")
    private Boolean star;

    @ApiModelProperty("会员ip")
    @TableField("member_ip")
    private String memberIp;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("显示状态[0-不显示，1-显示]")
    @TableField("show_status")
    private Boolean showStatus;

    @ApiModelProperty("购买时属性组合")
    @TableField("spu_attributes")
    private String spuAttributes;

    @ApiModelProperty("点赞数")
    @TableField("likes_count")
    private Integer likesCount;

    @ApiModelProperty("回复数")
    @TableField("reply_count")
    private Integer replyCount;

    @ApiModelProperty("评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]")
    @TableField("resources")
    private String resources;

    @ApiModelProperty("内容")
    @TableField("content")
    private String content;

    @ApiModelProperty("用户头像")
    @TableField("member_icon")
    private String memberIcon;

    @ApiModelProperty("评论类型[0 - 对商品的直接评论，1 - 对评论的回复]")
    @TableField("comment_type")
    private Integer commentType;


}
