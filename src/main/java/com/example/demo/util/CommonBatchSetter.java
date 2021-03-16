package com.example.demo.util;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName CommonBatchSetter
 * @Description 普通的批处理，完成从指定list中根据反射取得对应的值
 * @Autor ansonglin
 * @Date 2019/5/17 14:04
 * @Version 1.0
 **/
public class CommonBatchSetter implements BatchPreparedStatementSetter {

    private String para[];

    private List list;

    public CommonBatchSetter(String[] para, List list) {
        this.para = para;
        this.list = list;
    }

    //保存value值
    private Object value = null;

    public int getBatchSize() {
        return list.size();
    }

    public void setValues(PreparedStatement ps, int i) throws SQLException {
        Object ob = list.get(i);
        for (int j = 0; j < para.length; j++) {

            value = this.getValue(ob, para[j]);
            //如果是
            if (null != value) {
                ps.setObject(j + 1, value);
            } else {
                ps.setString(j + 1, null);
            }

        }
    }

    protected Object getValue(Object obj, String para) {
        return StringUtils.getProperty(obj, para);
    }
}
   