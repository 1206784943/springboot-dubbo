package com.dubbo.controller;

import javax.jms.Queue;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * 队列消息控制器
 */
@RestController
public class ProviderController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    /*
     * 消息生产者
     */
    @RequestMapping("/sendmsg")
    public void sendmsg(String msg) {
        // 指定消息发送的目的地及内容
        System.out.println("成功发送订阅消息：" + msg);
        this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
    }

    @RequestMapping("/send")
    public void send(String msg) {
        // 指定消息发送的目的地及内容
        System.out.println("成功发送广播消息：" + msg);
        this.jmsMessagingTemplate.convertAndSend(this.topic, msg);
    }
}