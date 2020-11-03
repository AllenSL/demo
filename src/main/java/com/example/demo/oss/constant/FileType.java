package com.example.demo.oss.constant;

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
    AVI("41564920"),
    /**
     * MP4
     */
    MP4("00000018667479706"),

    MP4_1("000000146674797069736"),

    /**
     * FLV.
     */
    FLV("464C5601050000000900"),

    /**
     * MP3.
     */
    MP3("49443303000000002176"),

    MP3_1("FFF328C4000");
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
   