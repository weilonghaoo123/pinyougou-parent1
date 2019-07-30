package cn.itcast.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 消息生产者
 *
 * @author Administrator
 */
@RestController
public class QueueController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping("/send")
    public void send(String text) {

        jmsMessagingTemplate.convertAndSend("itcast", text);
    }

    @RequestMapping("/sendmap")
    public void sendMap() {
        Map map = new HashMap<>();
        map.put("mobile", "13900001111");
        map.put("content", "恭喜获得 10 元代金券");
        jmsMessagingTemplate.convertAndSend("itcast_map", map);


    }

    @RequestMapping("/sendsms")
    public void sendSms() {
        Map map = new HashMap<>();
        map.put("mobile","18709283559");
        map.put("template_code","SMS_171117921");
        map.put("sign_name","黑鸟");
        map.put("param","{\"code\":\"666666\"}");
        jmsMessagingTemplate.convertAndSend("sms",map);
    }
}
