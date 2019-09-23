package com.gujun.springboot05.service;

import com.gujun.springboot05.entity.Book;

public interface ActiveMQBookService {

    void sendBook(Book book);

//    void receiveBook(Book book);

}
