package com.cloud.mall.thirdpart.file.config;

import cn.hutool.core.io.resource.ClassPathResource;
import lombok.extern.slf4j.Slf4j;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * FastDFS客户端工具类
 *
 * @author : scl
 * @date :  2022/9/25
 */
@Slf4j
public class FastDFSClient {

    /**
     * 初始化加载 FastDFS的TrackerServer配置
     */
    static {
        try {
            String filePath = new ClassPathResource("fdfs_client.conf").getFile().getAbsolutePath();
            ClientGlobal.init(filePath);
        } catch (Exception e) {
            log.error("FastDFS 初始化失败", e);
        }
    }

    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    public static String[] upload(FastDFSFile file) {
        // 获取文件的作者
        NameValuePair[] meta_list = new NameValuePair[1];
        meta_list[0] = new NameValuePair("author", file.getAuthor());

        // 接收返回数据
        String[] uploadResults = null;
        StorageClient storageClient = null;

        try {
            // 创建 StorageClient 客户端对象
            storageClient = getTrackerClient();

            /**
             * 文件上传
             * 1) 文件字节数组
             * 2) 文件扩展名
             * 3) 文件作者
             */
            uploadResults = storageClient.upload_file(file.getContent(), file.getExt(), meta_list);
        } catch (Exception e) {
            log.error("上传文件失败: " + file.getName(), e);
        }

        if (uploadResults == null && storageClient != null) {
            log.error("上传文件错误，错误码: " + storageClient.getErrorCode());
        }
        // 获取组名
        String groupName = uploadResults[0];
        // 获取文件存储路径
        String remoteFileName = uploadResults[1];
        return uploadResults;
    }

    /**
     * 获取文件信息
     *
     * @param groupName      组名
     * @param remoteFileName 文件存储完整名
     * @return
     */
    public static FileInfo getFile(String groupName, String remoteFileName) {
        try {
            StorageClient storageClient = getTrackerClient();
            return storageClient.get_file_info(groupName, remoteFileName);
        } catch (Exception e) {
            log.error("从FastDFS中获取文件错误", e);
        }
        return null;
    }

    /**
     * 文件下载
     *
     * @param groupName
     * @param remoteFileName
     * @return
     */
    public static InputStream downFile(String groupName, String remoteFileName) {
        try {
            // 创建 StorageClient
            StorageClient storageClient = getTrackerClient();
            // 下载文件
            byte[] fileByte = storageClient.download_file(groupName, remoteFileName);
            ByteArrayInputStream ins = new ByteArrayInputStream(fileByte);
            return ins;
        } catch (Exception e) {
            log.error("从FastDFS获取文件失败", e);
        }
        return null;
    }

    /**
     * 文件删除
     *
     * @param groupName
     * @param remoteFileName
     */
    public static void deleteFile(String groupName, String remoteFileName) {
        try {
            // 创建 StorageClient
            StorageClient storageClient = getTrackerClient();
            // 删除文件
            int i = storageClient.delete_file(groupName, remoteFileName);
        } catch (Exception e) {
            log.error("从FastDFS中文件删除失败", e);
        }
    }

    /**
     * 获取Storage组
     *
     * @param groupName 组名
     * @return
     */
    public static StorageServer[] getStoreStorages(String groupName) {
        try {
            // 创建 TrackerClient
            TrackerClient trackerClient = new TrackerClient();
            // 获取 TrackerServer
            TrackerServer trackerServer = trackerClient.getTrackerServer();
            //获取 Storage 组
            return trackerClient.getStoreStorages(trackerServer, groupName);
        } catch (Exception e) {
            log.error("从FastDFS获取Storage 组失败", e);
        }
        return null;
    }

    /**
     * 获取 Storage 信息,IP和端口
     *
     * @param groupName
     * @param remoteFileName
     * @return
     */
    public static ServerInfo[] getFetchStoages(String groupName, String remoteFileName) {
        try {
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getTrackerServer();
            return trackerClient.getFetchStorages(trackerServer, groupName, remoteFileName);
        } catch (Exception e) {
            log.error("获取Storage信息，IP 和端口失败", e);
        }
        return null;
    }

    /**
     * 获取 Tracker 服务地址
     *
     * @return
     */
    public static String getTrackerUrl() {
//        return "http://" + getTrackerServer().getInetSocketAddress().getHostString() + ":" + ClientGlobal.getG_tracker_http_port() + "/";
        return "http://" + getTrackerServer().getInetSocketAddress().getHostString() + "/";
    }

    /**
     * 获取Storage 客户端
     *
     * @return
     */
    private static StorageClient getTrackerClient() {
        TrackerServer trackerServer = getTrackerServer();
        StorageClient storageClient = new StorageClient(trackerServer, null);
        return storageClient;
    }

    /**
     * 获取 Tracker
     *
     * @return
     */
    private static TrackerServer getTrackerServer() {
        try {
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getTrackerServer();
            return trackerServer;
        } catch (Exception e) {
            log.error("获取Tracker 失败", e);
        }
        return null;
    }
}