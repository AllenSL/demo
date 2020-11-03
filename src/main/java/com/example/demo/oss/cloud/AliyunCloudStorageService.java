package com.example.demo.oss.cloud;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.DeleteObjectsRequest;
import com.aliyun.oss.model.DeleteObjectsResult;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.example.demo.exception.CommonException;
import com.example.demo.exception.ExceptionConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AliyunCloudStorageService
 * @Description 阿里云OSS存储实现
 * @Autor ansonglin
 * @Date 2019/5/5
 * @Version 1.0
 **/
@Slf4j
public class AliyunCloudStorageService extends CloudStorageService {
    private OSSClient client;
    private String prefix;


    public AliyunCloudStorageService(CloudStorageConfig config, Integer flag) {
        this.config = config;
        if (null == flag) {
            prefix = config.getAliyundefaultPrefix();
        } else if (flag == 1) {
            //图片
            prefix = config.getAliyunPicPrefix();
        } else if (flag == 2) {
            //视频
            prefix = config.getAliyunVideoPrefix();
        } else {
            //音频
            prefix = config.getAliyunAudioPrefix();
        }
        // 初始化云服务配置
        init();
    }

    private void init() {
        client = new OSSClient(config.getAliyunEndPoint(), config.getAliyunAccessKeyId(),
                config.getAliyunAccessKeySecret());
    }

    @Override
    public String upload(byte[] data, String path) {
        return upload(new ByteArrayInputStream(data), path);
    }

    @Override
    public String upload(InputStream inputStream, String path) {
        try {
            client.putObject(config.getAliyunBucketName(), path, inputStream);
        } catch (Exception e) {
            log.error("上传文件失败，原因：{}", e.getMessage(), e);
            throw new CommonException(ExceptionConstant.CONFIG_ERROR_CODE, "上传文件失败，请检查配置信息");
        }
        client.shutdown();
        return config.getAliyunDomain() + "/" + path;
    }

    @Override
    public String uploadSuffix(byte[] data, String suffix) {
        return upload(data, getPath(prefix, suffix));
    }

    @Override
    public String uploadSuffix(InputStream inputStream, String suffix) {
        return upload(inputStream, getPath(prefix, suffix));
    }

    @Override
    public String uploadInrealName(byte[] data, String realName) {
        return upload(data, getPathWithName(prefix, realName));
    }

    @Override
    public InputStream getInputStreamByPath(String keyPath) {
        InputStream objectContent = client.getObject(config.getAliyunBucketName(), keyPath).getObjectContent();
        try {
            if (null != objectContent) {
                objectContent.close();
            }
            client.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objectContent;
    }

    @Override
    public List<String> getAllFiles() {
        return getAllFiles(null, null);
    }

    /**
     * 批量删除OSS云文件
     *
     * @param files
     */
    @Override
    public void batchDelFiles(List<String> files) {
        log.warn("开始删除文件：{}...", files.toString());
        DeleteObjectsResult deleteObjectsResult = client.deleteObjects(new DeleteObjectsRequest(config.getAliyunBucketName()).withKeys(files));
        log.info("文件删除完成,信息：" + deleteObjectsResult.getDeletedObjects().toString());
        client.shutdown();
    }

    /**
     * 获取所有文件列表
     *
     * @param bucketName
     * @param prefix     存储路径前缀
     * @return
     */
    public List<String> getAllFiles(String bucketName, String prefix) {
        ObjectListing objectListing = new ObjectListing();
        if (StringUtils.isEmpty(bucketName) && StringUtils.isEmpty(prefix)) {
            objectListing = client.listObjects(config.getAliyunBucketName());
        } else {
            objectListing = client.listObjects(bucketName, prefix);
        }
        List<String> files = new ArrayList<>();
        for (OSSObjectSummary os : objectListing.getObjectSummaries()) {
            files.add(os.getKey());
        }
        client.shutdown();
        return files;
    }
}
   