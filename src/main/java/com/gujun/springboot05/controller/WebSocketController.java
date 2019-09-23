package com.gujun.springboot05.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("webSocket")
@RestController
public class WebSocketController {

    @RequestMapping("/goWebSocket01")
    public ModelAndView goWebSocket(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("webSocket/webSocket01");
        return mv;
    }


}
