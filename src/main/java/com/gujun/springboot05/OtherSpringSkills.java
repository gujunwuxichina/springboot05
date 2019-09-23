package com.gujun.springboot05;

public class OtherSpringSkills {

    /*
        异步线程池：
        一般一个请求都是在同一个线程中运行的，但有时候需要异步，即一个请求可能存在两个或两个以上的线程；
        如：请求生成报表，涉及到数据查询会很多，很耗时，此时请求生成和生成报表过程应该在不同的线程中进行；
        Spring中定义了一个AsyncConfigurer接口，是一个可以配置异步线程池的接口，方法：
        Executor getAsyncExecutor(),返回自定义线程池,这样在开启异步时，线程池就会提供空闲线程来执行异步任务；
        AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler(),因为线程中的业务逻辑可能会抛出异常，所有就需要
        一个处理异常的方法；

     */


    /*
        异步消息：
        有时会需要与其它系统集成，发生消息给其它系统，让其完成对应的功能；
        如,发送短信,各个业务系统需要通知客户时，可以通过消息发送到短信系统，再发送短信给客户；
        对于业务系统而言，短信系统是一个异步的系统，可能发送消息后，短信系统因为繁忙而没有立刻发送短信；
        为了给其它系统发送消息，Java引入了JMS(Java Message Service)；
        JMS按其规范分为点对点和发布订阅；
        JMS服务规范的实现：
        ActiveMQ,分布式的Kafka,更安全可靠的AMQP协议，实现AMQP的有RabbitMQ；

        1.ActiveMQ
        在Springboot配置文件中配置，Springboot就会根据配置文件初始化许多与ActiveMQ相关的对象，如JMS连接工厂
        连接池，JmsTemplate对象等；消息的发送和接收都可以通过JmsTemplate去处理；
        对于接收消息，Spring提供了注解@JmsListener；

        2.AMQP-RabbitMQ HHH

     */

    /*
        定时任务：
        在配置类中加入@EnableScheduling即可；再在需要的业务逻辑方法上用@Scheduled注解即可；
        @Scheduled配置项：
        cron,String,使用表达式的方式定义任务执行时间；
        zone,String,设置区域时间；
        fixedDelay,long,表示从上一个任务完成开始到下一个任务开始的间隔时间，单位毫秒；
        fixedDelay,String,同上，使用字符串表示，这样可以通过SpEL引入配置文件中的值；
        initialDelay,long,在SpringIoC容器初始化后，首次任务执行延迟时间，单位毫秒；
        initialDelayString,String,同上；
        fixedRate,long,表示从上一个任务开始到下一个任务开始的间隔时间，单位毫秒；
        fixedRateString,String,同上；

        cron:
        有6~7个空格分隔的时间元素，依次为 秒 分 时 天 月 星期 年，其中年不是必需的；
        ？表示不指定值，用于处理天和星期配置的冲突；
        *表示任意值；
        -指定时间区间；
        /指定时间间隔执行；
        L最后的；
        #第几个；
        ,列举多项；

        H

     */

    /*
        WebSocket应用：
        WebSocket协议是基于TCP的网络协议；实现了浏览器与服务器双工通信；
        允许服务器主动发送消息给客户端，客户端发送消息到服务器，服务端再转发消息给客户端，这样就可以实现客户端之间的交互；
        并不是所有浏览器都支持WebSocket协议，为了兼容那些没有实现的浏览器，还需要通过STOMP协议来完成这些兼容；
        STOMP HHH
     */

}
