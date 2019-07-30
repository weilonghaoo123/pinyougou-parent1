package com.pinyougou.user.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import com.alibaba.fastjson.JSON;
import com.pinyougou.user.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.mapper.TbUserMapper;
import com.pinyougou.pojo.TbUser;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;


/**
 * 服务实现层
 *
 * @author Administrator
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TbUserMapper userMapper;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private Destination smsDestination;

    @Value("${template_code}")
    private String template_code;

    @Value("${sign_name}")
    private String sign_name;


    /**
     * 增加
     */
    @Override
    public void add(TbUser user) {
        user.setCreated(new Date());//创建日期
        user.setUpdated(new Date());//修改日期
        String password = DigestUtils.md5Hex(user.getPassword());//对密码加密
        user.setPassword(password);
        userMapper.insert(user);
    }

    @Override
    public void createSmsCode(final String phone) {
        //随机生成6位随机数
        final String code = (long) (Math.random() * 1000000) + "";;
        //存入redis
        redisTemplate.boundHashOps("smscode").put(phone, code);
        System.out.println("电话" + phone);
        System.out.println("验证码为" + redisTemplate.boundHashOps("smscode").get(phone));//995905
        //发送到 activeMQ ....
        jmsTemplate.send(smsDestination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                MapMessage mapMessage = session.createMapMessage();
                mapMessage.setString("mobile", phone);//手机号
                mapMessage.setString("template_code","SMS_171117921");//模板编号
                mapMessage.setString("sign_name","黑鸟");//签名
                Map m = new HashMap();
                m.put("code", code);//995905
                mapMessage.setString("param", JSON.toJSONString(m));//参数
                return mapMessage;
            }
        });
    }

    /**
     * 判断验证码是否正确
     */
    @Override
    public boolean checkSmsCode(String phone, String code) {
        //得到缓存中存储的验证码
        String sysCode = (String) redisTemplate.boundHashOps("smscode").get(phone);
        if (sysCode == null) {
            return false;
        }
        if (!sysCode.equals(code)) {
            return false;
        }

        return true;
    }

}
