package com.gujun.springboot05.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private int count=1;    //计数器

//    @Scheduled(fixedRate = 1000)    //每秒执行
    @Async  //异步执行
    @Override
    public void job1() {
        System.out.println(Thread.currentThread().getName()+"-"+count);
        count++;
    }

    @Scheduled(cron = "0 * 11 * * ?")   //每天11:00到11：59每分钟执行一次
    @Async
    @Override
    public void job2() {
        System.out.println("start");
        System.out.println(Thread.currentThread().getName());
    }

}
