package com.example.demo.oss.cloud;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @ClassName AliyunCloudStorageService
 * @Description 云存储配置信息
 * @Autor ansonglin
 * @Date 2019/5/5
 * @Version 1.0
 **/
@Configuration
@ConfigurationProperties(prefix = "oss.easyword")
@Data
@Service("ossConfigService")
public class CloudStorageConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    //云存储类型
    private Integer type;
    //阿里云绑定的域名
    private String aliyunDomain;
    //文件默认存储路径
    private String aliyundefaultPrefix;
    //阿里云图片存储路径前缀
    private String aliyunPicPrefix;
    //阿里云视频存储路径前缀
    private String aliyunVideoPrefix;
    //阿里云音频存储路径前缀
    private String aliyunAudioPrefix;
    //阿里云db存储路径前缀
    private String aliyunDbPrefix;
    //本地db存储路径
    private String aliyunDbLocation;
    //阿里云EndPoint
    private String aliyunEndPoint;
    //阿里云AccessKeyId
    private String aliyunAccessKeyId;
    //阿里云AccessKeySecret
    private String aliyunAccessKeySecret;
    //阿里云BucketName
    private String aliyunBucketName;

}
