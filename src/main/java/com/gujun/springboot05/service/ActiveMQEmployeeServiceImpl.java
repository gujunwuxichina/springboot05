package com.gujun.springboot05.service;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.gujun.springboot05.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ActiveMQEmployeeServiceImpl implements ActiveMQEmployeeService {

    @Autowired
    private JmsTemplate jmsTemplate;    //由SpringBoot自动配置机制根据配置文件自动生成的；

    @Override
    public void sendEmployee(Employee employee) {
        System.out.println("发送消息:"+employee);
        /*
            convertAndSend()一个发送消息的方法，
            先要转换(convert),默认情况下JmsTemplate会提供一个SimpleMessageConverter提供转换规则，实现了MessageConverter接口，
            如果要使用其它序列号器，调用JmsTemplate的setMessageConverter()进行设置；
         */
        jmsTemplate.convertAndSend(employee);
//        jmsTemplate.convertAndSend("",employee);  //自定义发送的地址，上面是采用默认地址
    }

    @Override
    @JmsListener(destination = "${spring.jms.template.default-destination}")    //使用@JmsListener注解，监听指定地址发送过滤的消息；
    public void receiveEmployee(Employee employee) {
        System.out.println("收到消息:"+employee);
    }

}
