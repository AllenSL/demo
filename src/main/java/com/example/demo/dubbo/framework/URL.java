package com.example.demo.dubbo.framework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class URL implements Serializable {
    private static final long serialVersionUID = -5429290109793907858L;
    private String hostName;
    private Integer port;


}
