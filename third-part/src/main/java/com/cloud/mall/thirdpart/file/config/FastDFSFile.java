package com.cloud.mall.thirdpart.file.config;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 文件
 *
 * @author : scl
 * @date :  2022/9/25
 */
@Data
@Accessors(chain = true)
public class FastDFSFile {

    /**
     * 文件名字
     */
    private String name;

    /**
     * 文件内容
     */
    private byte[] content;

    /**
     * 文件扩展名
     */
    private String ext;

    /**
     * 文件MD5摘要值
     */
    private String md5;

    /**
     * 文件创建作者
     */
    private String author;

    public FastDFSFile(String name, byte[] content, String ext, String height, String width, String author) {
        super();
        this.name = name;
        this.content = content;
        this.ext = ext;
        this.author = author;
    }

    public FastDFSFile(String name, byte[] content, String ext) {
        super();
        this.name = name;
        this.content = content;
        this.ext = ext;
    }
}