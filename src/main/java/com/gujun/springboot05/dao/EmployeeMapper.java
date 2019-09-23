package com.gujun.springboot05.dao;

import com.gujun.springboot05.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMapper {

    Employee getById(Integer eId);

}
