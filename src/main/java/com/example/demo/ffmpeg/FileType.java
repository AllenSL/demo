package com.example.demo.ffmpeg;

/**
 * @ClassName FileType
 * @Description 文件类型枚举类
 * @Autor ansonglin
 * @Date 2019/5/6 20:07
 * @Version 1.0
 **/
public enum FileType {

    /**
     * JEPG.
     */
    JPEG("FFD8FF"),

    /**
     * PNG.
     */
    PNG("89504E47"),

    /**
     * TIFF.
     */
    TIFF("49492A00"),

    /**
     * AVI.
     */
    AVI("avi"),
    /**
     * MP4
     */
    MP4("mp4"),
    /**
     * FLV.
     */
    FLV("flv"),

    /**
     * MP3.
     */
    MP3("mp3");

    private String value = "";

    /**
     * Constructor.
     */
    private FileType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
