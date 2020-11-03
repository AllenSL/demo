package com.example.demo.oss.cloud;

import org.apache.commons.lang.StringUtils;

import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * 云存储模板类
 *
 * @author ansonglin
 * @date 2018-05-05
 */
public abstract class CloudStorageService {
    /**
     * 云存储配置信息
     */
    CloudStorageConfig config;

    /**
     * 文件路径
     *
     * @param prefix 前缀
     * @param suffix 后缀
     * @return 返回上传路径
     */
    public String getPath(String prefix, String suffix) {
        //生成uuid
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        //文件路径
//      String path = DateUtils.format(new Date(), "yyyyMMdd") + "/" + uuid;
        String path = uuid;
        if (StringUtils.isNotBlank(prefix)) {
            path = prefix + "/" + path;
        }

        return path + suffix;
    }

    /**
     * 文件路径
     *
     * @param prefix   存储目录
     * @param realName 文件实际名字
     * @return
     */
    public String getPathWithName(String prefix, String realName) {
        return prefix + "/" + realName;
    }


    /**
     * 文件上传
     *
     * @param data 文件字节数组
     * @param path 文件路径，包含文件名
     * @return 返回http地址
     */
    public abstract String upload(byte[] data, String path);

    /**
     * uuid+yymmdd名称存储 文件上传
     *
     * @param data   文件字节数组
     * @param suffix 后缀
     * @return 返回http地址
     */
    public abstract String uploadSuffix(byte[] data, String suffix);

    /**
     * 文件上传
     *
     * @param inputStream 字节流
     * @param path        文件路径，包含文件名
     * @return 返回http地址
     */
    public abstract String upload(InputStream inputStream, String path);

    /**
     * 文件上传
     *
     * @param inputStream 字节流
     * @param suffix      后缀
     * @return 返回http地址
     */
    public abstract String uploadSuffix(InputStream inputStream, String suffix);

    /**
     * 以图片实际名称存储
     *
     * @param data
     * @param realName
     * @return
     */
    public abstract String uploadInrealName(byte[] data, String realName);

    /**
     * 获取文件的输入流
     *
     * @param keyPath 文件路径
     * @return
     */
    public abstract InputStream getInputStreamByPath(String keyPath);

    /**
     * 获取所有文件
     *
     * @return
     */
    public abstract List<String> getAllFiles();

    /**
     * 批量删除OSS文件
     *
     * @param files
     */
    public abstract void batchDelFiles(List<String> files);
}
