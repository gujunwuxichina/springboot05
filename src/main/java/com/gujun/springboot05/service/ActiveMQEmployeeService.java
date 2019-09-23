package com.gujun.springboot05.service;

import com.gujun.springboot05.entity.Employee;

public interface ActiveMQEmployeeService {

    void sendEmployee(Employee employee);

    void receiveEmployee(Employee employee);

}
