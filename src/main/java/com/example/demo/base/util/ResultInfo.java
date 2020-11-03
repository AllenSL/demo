package com.example.demo.base.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultInfo implements Serializable {
    private static final long serialVersionUID = -744567280769723204L;

    private int code = 0;
    private String msg;
    private Object data;

    public boolean isSuccess() {
        return this.code == 0 ? true : false;
    }
}
