package com.example.demo.oss.constant;

/**
 * @author ansonglin
 * @description 云存储常量类
 * @date 2019-05-05
 */
public class Constant {

    /**
     * 云服务商常量
     */
    public enum CloudService {
        /**
         * 阿里云
         */
        ALIYUN(1);

        private int value;

        CloudService(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

}
