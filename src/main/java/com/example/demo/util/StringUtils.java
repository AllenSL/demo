package com.example.demo.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Slf4j
public class StringUtils {

    /**
     * 字符串中字符反转如  ab&c%d -> dc&b%a
     */
    public String reverseChar(String str) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(str)) {
            return str;
        }
        HashMap<Integer, Object> map = new HashMap<>();
        char[] chars = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < chars.length; j++) {
            if (String.valueOf(chars[j]).matches("^[a-zA-Z]*")) {
                map.put(j, chars[j]);
                sb.append(chars[j]);
            }
        }
        StringBuffer sbf = new StringBuffer(str);
        Iterator<Map.Entry<Integer, Object>> iterator = map.entrySet().iterator();
        char[] chars1 = sb.reverse().toString().toCharArray();
        int a = 0;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Object> next = iterator.next();
            map.put(next.getKey(), chars1[a]);
            a++;
        }
        for (Map.Entry<Integer, Object> next : map.entrySet()) {
            sbf.replace(next.getKey(), next.getKey() + 1, String.valueOf(next.getValue()));
        }
        return sbf.toString();
    }


    /**
     * 从对象中取得指定对象的值
     *
     * @param obj  对象
     * @param name 字段名称
     * @return
     */
    public static Object getProperty(Object obj, String name) {
        //字段值
        Object result = null;

        if (obj instanceof Map) {
            result = (Object) ((Map) obj).get(name);
            if (result == null) {
                result = (Object) ((Map) obj).get(name.toLowerCase());
            }
            if (result == null) {
                result = (Object) ((Map) obj).get(name.toUpperCase());
            }
        } else {

            try {
                if (PropertyUtils.isReadable(obj, name)) {

                    result = PropertyUtils.getProperty(obj, name);

                } else if (PropertyUtils.isReadable(obj, name.toLowerCase())) {

                    result = PropertyUtils.getProperty(obj, name.toLowerCase());

                } else if (PropertyUtils.isReadable(obj, name.toUpperCase())) {

                    result = PropertyUtils.getProperty(obj, name.toUpperCase());
                }
            } catch (Exception ex) {
                log.error("错误：" + obj.getClass().getName() + "取不到" + name + "#");
            }

        }
        return result;
    }
}
