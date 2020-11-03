package com.example.demo.dubbo.framework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invocation implements Serializable {

    private static final long serialVersionUID = -6261193228547177034L;
    private String interfaceName;
    private String methodName;
    private Object[] params;
    private Class[] paramTypes;
}
