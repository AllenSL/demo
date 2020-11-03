package com.example.demo.mybatis.pojo;

import lombok.*;
import org.springframework.data.annotation.Id;

/**
 * 价格指数的定义
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceIndex implements Comparable<PriceIndex>{
    @Id
    private Long id;

    private String symbol;                  //币种对name

    /** 价格指数对应时间戳 . */
    private long   date;

    /** 平均价格指数 . */
    private String averagePrice;

    /** 币安交易所价格指数 . */
    private String price1;

    /** 火币交易所价格指数 . */
    private String price2;

    /** okCoin交易所价格指数 . */
    private String price3;

    /**  数据标识 0-分钟数据，1-小时数据 . */
    private int  datatype;

    /** 过期时间 单位：s .*/
    private Long expiration;


    @Override
    public int compareTo(PriceIndex o) {
        return id.compareTo(o.getId());
    }
}
