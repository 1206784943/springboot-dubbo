package com.dubbo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * mq消费者
 */
@Component
public class ConsumerService {


    @JmsListener(destination = "ActiveMQQueue")// 使用JmsListener配置消费者监听的队列，destination是队列名称
//    @SendTo("SQueue")// SendTo 会将此方法返回的数据,发送到消息队列 ,否则不设置返回类型-void
    public void receviceQueueMsg(String msg) {
        System.out.println("成功接受订阅消息：" + msg);
    }

    @JmsListener(destination="ActiveMQTopic")
    public void receviceTopicMsg(TextMessage msg) {//注：此处方法不可有返回值
        String str = "";
        try {
            str = msg.getText();
            System.out.println("成功接收广播消息："+ msg.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}