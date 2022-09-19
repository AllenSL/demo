package com.example.demo;

import com.example.demo.base.annotation.MyFirstAnnotation;
import com.example.demo.base.util.ResultInfo;
import com.example.demo.base.util.ResultUtil;
import com.example.demo.mybatis.pojo.PriceIndex;
import com.gome.platform.hotkey.client.ClientStarter;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.MultipartConfigElement;
import java.io.IOException;
import java.net.Inet4Address;
import java.util.*;
@ServletComponentScan
@Slf4j
@SpringBootApplication
@RestController
@EnableScheduling
@MapperScan("com.example.demo.mybatis.mapper")
//@EnableHystrix
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        Environment environment = context.getBean(Environment.class);
       log.info("应用启动成功，启动端口: {}" ,environment.getProperty("local.server.port"));
    }

    @RequestMapping("/options/Index/priceIndex/BTC_USDT")
    public ResultInfo test() {
        String content = null;
        try {
            content = DemoApplication.mock();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = JSONObject.fromObject(content);
        JSONArray a = JSONArray.fromObject(jsonObject.get("data"));
        List<PriceIndex> list = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            Object o = a.get(i);
            JSONObject jsonObject2 = JSONObject.fromObject(o);
            PriceIndex stu2 = (PriceIndex) JSONObject.toBean(jsonObject2, PriceIndex.class);
            list.add(stu2);
        }

        return ResultUtil.success(list);
    }

    private static String mock() throws IOException {
        ClassPathResource resource = new ClassPathResource("mock/response/1.txt");
        String content = StringUtils.join(FileUtils.readLines(resource.getFile(), "UTF-8").toArray(), "\n");
        return content;
    }


    @MyFirstAnnotation("吃喝")
    @RequestMapping("/test")
    public String testMyAnonocation() {
        System.out.println("===========sdsdsd=");
        HashMap<String, Integer> map = new HashMap<>();
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            next.getValue();
            next.getKey();
        }

        return "helloWorld" + Inet4Address.getLoopbackAddress();
    }

//    @PostMapping("/result")

    //    @HystrixCommand(fallbackMethod = "defaultquery")
    public ResultInfo query() {
        int a = 0;
        int b = 10 / a;
        System.out.println("333333333333333sssssss");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<html>");
        return ResultUtil.success();
    }

    public ResultInfo defaultquery() {
        System.out.println("错误啦。。。。");
        return ResultUtil.success("there is a wrong");
    }

    /**
     * 文件上传配置
     *
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大100M,DataUnit提供5中类型B,KB,MB,GB,TB
        factory.setMaxFileSize(DataSize.of(100, DataUnit.MEGABYTES));
        //设置总上传数据总大小100M
        factory.setMaxRequestSize(DataSize.of(1024, DataUnit.MEGABYTES));
        return factory.createMultipartConfig();
    }

    @Bean("mongoTransaction")
    MongoTransactionManager transactionManager(MongoDbFactory dbFactory) {
        return new MongoTransactionManager(dbFactory);
    }

    public void init(){
        ClientStarter.Builder builder = new ClientStarter.Builder();
        ClientStarter starter = builder.build();
        starter.startPipeline();
    }
}

