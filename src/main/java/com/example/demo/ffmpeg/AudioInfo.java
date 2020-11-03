package com.example.demo.ffmpeg;

import lombok.Data;

/**
 * @ClassName AudioInfo
 * @Description TODO
 * @Autor ansonglin
 * @Date 2019/5/30 10:50
 * @Version 1.0
 **/
@Data
public class AudioInfo {

    private String path;

    private String fileType;

    private Integer duration;

    private String bitrate;

}
   