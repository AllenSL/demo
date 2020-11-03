package com.example.demo.oss.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName OssResultDto
 * @Description 批量上传结果返回实体
 * @Autor ansonglin
 * @Date 2019/5/8 10:11
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileUpLoadResultList implements Serializable {

    private static final long serialVersionUID = 6524526789084143531L;
    /**
     * 上传成功文件集合
     */
    public List<FileUpLoadResult> susscessFiles;

    /**
     * 上传失败文件集合
     */
    public List<FileUpLoadResult> failFiles;

}
   