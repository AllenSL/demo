package com.example.demo.config;

import cn.com.gome.cloud.openplatform.diamond.DiamondOP;
import com.gome.architect.idgnrt.IDGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IDGeneratorConfig {
    /**
     * 获取zookeeper地址
     */
    private static String defaultZookeeperAddress = DiamondOP.getProperty("NPOP_POPCOMMON", "SPRING_XML_PROPERTIES_CONF", "idZookeeperAddress", "");

    @Bean
    public IDGenerator capitalAccountIdGenerator() {
        IDGenerator idGenerator = new IDGenerator(defaultZookeeperAddress, "test.table.col2");
        idGenerator.init();
        return idGenerator;
    }

}