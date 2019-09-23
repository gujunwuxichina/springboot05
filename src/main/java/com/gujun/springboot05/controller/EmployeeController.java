package com.gujun.springboot05.controller;

import com.alibaba.fastjson.JSONObject;
import com.gujun.springboot05.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("employee")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/goEmployee")
    public ModelAndView goEmployee(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("employee/employee");
        return mv;
    }

    @RequestMapping("/testAsync")
    public void testAsync() throws InterruptedException {
        employeeService.testAsync();
        System.out.println("控制器线程:"+Thread.currentThread().getName());  //先打印
    }

}
