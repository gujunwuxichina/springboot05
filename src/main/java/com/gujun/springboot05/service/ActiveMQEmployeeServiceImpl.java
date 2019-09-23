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
    private JmsTemplate jmsTemplate;

    @Override
    public void sendEmployee(Employee employee) {
        System.out.println("发送消息:"+employee);
        jmsTemplate.convertAndSend(employee);
    }

    @Override
    @JmsListener(destination = "${spring.jms.template.default-destination}")
    public void receiveEmployee(Employee employee) {
        System.out.println("收到消息:"+employee);
    }

}
