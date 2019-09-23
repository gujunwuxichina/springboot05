package com.gujun.springboot05.service;

import org.springframework.stereotype.Service;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/ws")  //让Spring创建WebSocket的服务端点，请求地址是/ws;
@Service
public class WebSocketServiceImpl {

    private static int onlineCount=0;   //记录当前在线数量，应该设计成线程安全的；

    //线程安全的Set，用来存储每个客户端对应的WebSocketServiceImpl对象；
    private static CopyOnWriteArraySet<WebSocketServiceImpl> webSocketServices=new CopyOnWriteArraySet<>();

    private Session session;    //与某个客户端连接的会话，通过它来给客户端发送数据；

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @OnOpen //客户端打开WebSocket服务端点调用的方法
    public void onOpen(Session session){
        this.session=session;
        webSocketServices.add(this);
        addCount();
        System.out.println("新连接加入,当前在线总数为:"+getCount());
        try {
            sendMessage("有新连接加入!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClose    //客户端关闭WebSocket服务端点调用的方法
    public void onClose(){
        webSocketServices.remove(this);
        sunCount();
        System.out.println("有人退出连接,当前在线总数:"+getCount());
    }

    @OnMessage  //客户端发送消息，WebSocket服务端点调用的方法
    public void onMessage(String message,Session session){
        System.out.println("来自客户端的消息:"+message);
        //群发
        for(WebSocketServiceImpl webSocketService:webSocketServices){
            //获取当前用户名称
            try {
                String username=webSocketService.getSession().getUserPrincipal().getName();
                System.out.println(username);
                webSocketService.sendMessage(message);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @OnError    //客户端请求WebSocket服务发生异常调用的方法
    public void onError(Session session,Throwable error){
        System.out.println("连接webSocket服务错误!");
        error.printStackTrace();
    }

    private void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    private static synchronized int getCount(){
        return onlineCount;
    }

    private static synchronized void addCount(){
        WebSocketServiceImpl.onlineCount++;
    }

    private static  synchronized void sunCount(){
        WebSocketServiceImpl.onlineCount--;
    }

}
