package com.gujun.springboot05.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.websocket.server.ServerEndpoint;

@Configuration
public class WebSocketConfig {

    //开发简易WebSocket服务:
    //创建ServerEndpointExporter对象，通过其可以定义WebSocket服务器端点，
    //通过@ServerEndpoint定义一个端点服务类，在该站点服务类中还可以定义WebSocket的打开、关闭、错误和发送消息的方法；
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }

}
