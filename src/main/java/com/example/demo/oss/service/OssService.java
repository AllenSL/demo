package com.example.demo.oss.service;

import com.example.demo.oss.entity.FileUpLoadResult;
import com.example.demo.oss.entity.FileUpLoadResultList;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName OssService
 * @Description TODO
 * @Autor ansonglin
 * @Date 2019/5/7 9:03
 * @Version 1.0
 **/
public interface OssService {

    /**
     * 文件以UUID命名批量存储
     * @param files
     * @param fileType  上传文件类型 图片1、视频2、音频3
     * @return
     */
    FileUpLoadResultList batchUploadFile(MultipartFile[] files, Integer fileType);

    /**
     * 文件以UUID命名存储
     * @param file
     * @param fileType  上传文件类型 图片1、视频2、音频3
     * @return
     */
    FileUpLoadResult upLoadFile(MultipartFile file, Integer fileType);

    /**
     * 以指定文件名上传
     *
     * @param file 指定文件
     * @param name 指定文件名
     * @param fileType 上传文件类型 图片1、视频2、音频3
     * @return
     */
    String upLoadFile(MultipartFile file, String name, Integer fileType) throws IOException;

    /**
     * @param key 文件路径
     * @return
     */
    InputStream getInputStreamBykey(String key);

    /**
     * 获取默认bucketName所有文件列表
     *
     * @return
     */
    List<String> getAllfilesInDefaultBucket();

    /**
     * 批量删除OSS文件
     *
     * @param files
     */
    void batchDelOssFiles(List<String> files);

    /**
     * 下载文件到指定目录
     *
     * @param url      文件路径
     * @param filePath 文件保存路径
     * @param fileName 保存文件名称
     * @return
     */
    void saveFileToPath(String url, String filePath, String fileName);
}
   