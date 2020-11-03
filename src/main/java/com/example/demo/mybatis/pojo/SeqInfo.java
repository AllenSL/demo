package com.example.demo.mybatis.pojo;

import lombok.Data;

@Data
public class SeqInfo {
    private String seqName;

    private Long value;

    private Long minValue;

    private Long maxValue;

    private Short year;

    private Byte anonymous;

}