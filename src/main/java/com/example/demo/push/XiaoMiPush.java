package com.example.demo.push;

import com.alibaba.fastjson.JSONObject;
import com.xiaomi.xmpush.server.*;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ansonglin
 * @className XiaoMiPush
 * @description 小米手机推送服务
 * @date 2019/10/21 14:20
 * @cersion 1.0
 **/
@Slf4j
public class XiaoMiPush {

    /**
     * 指定alias推送(单个或多个)
     *
     * @param messagePayload 消息
     * @param title          消息标题
     * @param description    消息描述
     * @param adsType        消息类型
     * @param adsLinks       消息链接
     * @param aliasList      指定alias
     */
    public static boolean xiaomiBatchPush(String messagePayload, String title, String description, String adsType,
                                          String adsLinks, List<String> aliasList, Map<String, String> parm) {
        log.info("小米设备：{}", aliasList);
        try {
            JSONObject result = builderMessageAndSender(messagePayload, title, description, adsType, adsLinks, parm);
            Message message = (Message) result.get("message");
            Sender sender = (Sender) result.get("sender");
            Result pushResult = sender.send(message, aliasList, 3);
            log.debug("++++推送到小米结果为：{}", pushResult);
            if (pushResult != null) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("小米指定alias失败：", e);
        }
        return false;
    }

    public static JSONObject builderMessageAndSender(String messagePayload, String title, String description, String adsType, String adsLinks, Map<String, String> parm) {
        //boolean isProd = myProperties.getPush().isProd();
        boolean isProd = ConstantsUnit.xiaomiProd;
        // 设置环境 正式环境下使用Push服务，启动时需要调用如下代码
        Constants.useOfficial();
        Map<String, String> map = new HashMap<>();
        map.put("ads_type", adsType);
        map.put("ads_links", adsLinks);
        // 构建消息
        Message message = new Message.Builder()
                .title(title)
                .description(description)
                .payload(messagePayload)
                /**  app是否弹出通知 开启/关闭(1/0) .*/
//                .extra(Constants.EXTRA_PARAM_NOTIFY_FOREGROUND,Constants.NOTIFY_LAUNCHER_ACTIVITY)
                .extra(Constants.EXTRA_PARAM_NOTIFY_EFFECT, Constants.NOTIFY_WEB)
//                .extra(parm)
                .extra(Constants.EXTRA_PARAM_WEB_URI, "http://www.baidu.com")
                .restrictedPackageName(ConstantsUnit.xiaomiPackageName)
                /** 使用默认提示音提示. */
                .notifyType(1)
                /** 用户离线状态，消息存活时间(ms). */
                //.timeToLive(1000)
                /** 定时发送消息ms(7天内). */
                //.timeToSend(1000)
                /** 多条消息需要设置id，否则会覆盖上一条. */
                .notifyId(1)
                .build();
        // 构建发送
        Sender sender = new Sender(ConstantsUnit.xiaomiAppSecretKey);
        JSONObject result = new JSONObject();
        result.put("message", message);
        result.put("sender", sender);
        return result;
    }


    /**
     * 根据regids推送消息
     *
     * @param regIds regId列表
     * @throws Exception
     */
    private static void sendMessage(List<String> regIds) throws Exception {
        Constants.useOfficial();
        Sender sender = new Sender(ConstantsUnit.xiaomiAppSecretKey);
        String messagePayload = "This is a message";
        String title = "notification title";
        String description = "notification description";
        Message message = new Message.Builder()
                .title(title)
                .description(description).payload(messagePayload)
                .restrictedPackageName(ConstantsUnit.xiaomiPackageName)
                /** 使用默认提示音提示. */
                .notifyType(1)
                .build();
        /** 发送消息到一组设备上, regids个数不得超过1000个. */
        Result send = sender.send(message, regIds, 3);
        System.out.println(send.getData() + " " + send.getErrorCode().getDescription());
    }

    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>();
        list.add("vWBrBT/WLo1MznUW5TnWzX3VU1kr5KC+j9Guf8onOLJAM195mCTTYvHONp7xCIXM");
        xiaomiBatchPush("1223", "title", "description", "String", "http://www.baidu.com", list, null);
    }

}
   