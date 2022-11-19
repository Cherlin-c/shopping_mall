package com.cloud.mall.thirdpart.file.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cloud.mall.common.utils.R;
import com.cloud.mall.thirdpart.file.config.FastDFSClient;
import com.cloud.mall.thirdpart.file.config.FastDFSFile;
import com.cloud.mall.thirdpart.file.entity.FileResource;
import com.cloud.mall.thirdpart.file.service.IFileResourceService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件管理
 *
 * @author : scl
 * @date :  2022/9/25
 */
@Slf4j
@Api("文件管理")
@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private IFileResourceService iFileResourceService;

    @PostMapping("upload")
    public R upload(MultipartFile file) {
        try {
            String md5 = SecureUtil.md5(file.getInputStream());
            FileResource resource = iFileResourceService.getOne(Wrappers.lambdaQuery(FileResource.class)
                    .eq(FileResource::getMd5, md5));
            if (ObjectUtil.isNull(resource)) {

                // 文件上传
                // 1. 获取文件属性
                // 1.1. 原始文件名
                String originalFilename = file.getOriginalFilename();
                // 1.2. 文件内容
                byte[] fileBytes = file.getBytes();
                // 1.3 文件扩展名  test.jpg -> jpg
                String ext = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);

                // 2. 创建 FastDFSFile
                FastDFSFile fastDFSFile = new FastDFSFile(originalFilename, fileBytes, ext);
                // 3. 调用工具类上传
                // uploadResult 第一个只是 group 第二个值是：物理路径
                String[] uploadResult = FastDFSClient.upload(fastDFSFile);

                // 预览url
                String url = FastDFSClient.getTrackerUrl() + uploadResult[0] + "/" + uploadResult[1];
                log.info("上传成功 url={}", url);
                resource = new FileResource();
                resource.setName(originalFilename)
                        .setType(ext)
                        .setUrl(url)
                        .setMd5(md5);
                iFileResourceService.save(resource);
            }
            return R.ok().put("data", resource);
        } catch (Exception e) {
            return R.error("上传失败" + e.getMessage());
        }
    }


    /**
     * 列表
     */
    @GetMapping("/list")
    public R list() {
        return R.ok().put("data", iFileResourceService.list());
    }


    /**
     * 信息
     */
    @GetMapping("/{id}")
    public R info(@PathVariable("id") Long id) {
        FileResource fileResource = iFileResourceService.getById(id);

        return R.ok().put("fileResource", fileResource);
    }
}