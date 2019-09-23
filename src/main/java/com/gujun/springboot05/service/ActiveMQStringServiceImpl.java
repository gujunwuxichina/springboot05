package com.gujun.springboot05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ActiveMQStringServiceImpl implements ActiveMQStringService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void sendMsg(String msg) {
        System.out.println("发送消息:"+msg);
        /*
            此处是默认地址；
            默认下JmsTemplate会使用SimpleMessageConverter提供转换规则；若要使用其它序列化器，可以使用jmsTemplage.setConverter()设置即可；
         */
        jmsTemplate.convertAndSend(msg);
    }

//    @Override
//    @JmsListener(destination = "${spring.jms.template.default-destination}")
//    public void receiveMsg(String msg) {
//        System.out.println("收到消息:"+msg);
//    }

}
