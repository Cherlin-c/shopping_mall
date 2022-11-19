package com.cloud.mall.thirdpart.file.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * 文件资源
 * </p>
 *
 * @author scl
 * @since 2022-10-02
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("file_resource")
@ApiModel(value = "FileResource对象", description = "文件资源")
public class FileResource implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("文件名")
    private String name;

    @ApiModelProperty("文件类型")
    private String type;

    @ApiModelProperty("地址")
    private String url;

    @ApiModelProperty("文件md5")
    private String md5;

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("修改时间")
    private String modifyTime;


}
