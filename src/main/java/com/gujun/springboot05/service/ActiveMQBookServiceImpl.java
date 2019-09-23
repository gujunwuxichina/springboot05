package com.gujun.springboot05.service;

import com.gujun.springboot05.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ActiveMQBookServiceImpl implements ActiveMQBookService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void sendBook(Book book) {
        System.out.println("发送消息:"+book);
        jmsTemplate.convertAndSend(book);
    }

//    @Override
//    @JmsListener(destination = "${spring.jms.template.default-destination}")
//    public void receiveBook(Book book) {
//        System.out.println("收到消息:"+book);
//    }

}
