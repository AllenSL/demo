package com.example.demo.oss.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName FileUpLoadResult
 * @Description 文件上传结果实体
 * @Autor ansonglin
 * @Date 2019/5/9 20:46
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileUpLoadResult implements Serializable {

    private static final long serialVersionUID = 4679613654893010046L;
    /**
     * 文件名
     */
    String fileName;
    /**
     * 文件地址
     */
    String fileUrl;
    /**
     * 结果信息
     */
    String resultMsg;

    /**
     * 视频播放时长，其他文件类型为空
     */
    @JsonIgnore
    String playTime;

    public FileUpLoadResult(String fileName, String fileUrl, String resultMsg) {
        this.fileName = fileName;
        this.fileUrl = fileUrl;
        this.resultMsg = resultMsg;
    }
}
   