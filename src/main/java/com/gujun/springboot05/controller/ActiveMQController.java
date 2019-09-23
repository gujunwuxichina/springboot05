package com.gujun.springboot05.controller;

import com.alibaba.fastjson.JSONObject;
import com.gujun.springboot05.entity.Book;
import com.gujun.springboot05.entity.Employee;
import com.gujun.springboot05.service.ActiveMQBookService;
import com.gujun.springboot05.service.ActiveMQEmployeeService;
import com.gujun.springboot05.service.ActiveMQStringService;
import com.gujun.springboot05.service.EmployeeService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("activeMQ")
@RestController
public class ActiveMQController {

    @Autowired
    private ActiveMQStringService activeMQStringService;

    @Autowired
    private ActiveMQEmployeeService activeMQEmployeeService;

    @Autowired
    private ActiveMQBookService activeMQBookService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/sendMsg/{msg}")
    public JSONObject sendMsg(@PathVariable("msg") String msg){
        JSONObject jsonObject=new JSONObject();
        activeMQStringService.sendMsg(msg);
        jsonObject.put("发送消息",msg);
        return jsonObject;
    }

    @GetMapping("/sendEmployee/{eId}")
    public JSONObject sendEmployee(@PathVariable("eId") Integer eId){
        JSONObject jsonObject=new JSONObject();
        Employee employee=employeeService.getById(eId);
        activeMQEmployeeService.sendEmployee(employee);
        jsonObject.put("receiveEmployee",employee);
        return jsonObject;
    }

    @GetMapping("/sendBook")
    public JSONObject sendBook(){
        JSONObject jsonObject=new JSONObject();
        Book book=new Book("java",100);
        activeMQBookService.sendBook(book);
        jsonObject.put("book",book);

        return jsonObject;
    }

}
