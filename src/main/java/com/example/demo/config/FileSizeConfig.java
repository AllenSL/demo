package com.example.demo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName FileSizeConfig
 * @Description 上传文件大小配置映射类
 * @Autor ansonglin
 * @Date 2019/5/7 15:54
 * @Version 1.0
 **/
@Data
@Component
public class FileSizeConfig {
    public static int picSize;
    public static int vedioSize;
    public static int audioSize;

    @Value("${file.picSize}")
    public void setPicSize(int picSize) {
        FileSizeConfig.picSize = picSize;
    }

    @Value("${file.vedioSize}")
    public void setVedioSize(int vedioSize) {
        FileSizeConfig.vedioSize = vedioSize;
    }

    @Value("${file.audioSize}")
    public void setAudioSize(int audioSize) {
        FileSizeConfig.audioSize = audioSize;
    }
}
