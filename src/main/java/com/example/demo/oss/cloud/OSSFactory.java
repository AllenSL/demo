package com.example.demo.oss.cloud;


import com.example.demo.oss.constant.Constant;
import com.example.demo.util.SpringContextUtils;

/**
 * 文件上传Factory,可增加其他数据存储源如：腾讯云 七牛云等
 *
 * @author ansonglin
 * @date 2019-05-05
 */
public final class OSSFactory {

    private static CloudStorageConfig cloudStorageConfig;

    static {
        OSSFactory.cloudStorageConfig = (CloudStorageConfig) SpringContextUtils.getBean("ossConfigService");
    }

    public static CloudStorageService build(Integer flag) {
        //获取云存储配置信息
        if (cloudStorageConfig.getType() == Constant.CloudService.ALIYUN.getValue()) {
            return new AliyunCloudStorageService(cloudStorageConfig, flag);
        }
        return null;
    }

}
