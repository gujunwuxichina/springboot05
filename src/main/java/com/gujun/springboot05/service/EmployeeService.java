package com.gujun.springboot05.service;

import com.gujun.springboot05.entity.Employee;

public interface EmployeeService {

    void testAsync() throws InterruptedException;

    Employee getById(Integer eId);

}
