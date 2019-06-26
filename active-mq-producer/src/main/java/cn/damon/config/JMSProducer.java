package cn.damon.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * damon
 */
@Service
public class JMSProducer {

    @Autowired
    private JmsTemplate jmsTemplate;


    // 发送消息，destination是发送到的队列，message是待发送的消息
    public void sendMessage(Destination destination, final String message){
        jmsTemplate.convertAndSend(destination, message);
    }

    /**
     * 发送队列消息
     * @param endPointName 端点名
     * @param message 消息
     */
    public void sendQueueMessage(String endPointName,final String message){
        Destination destination = new ActiveMQQueue(endPointName);
        sendMessage(destination,message);
    }
}
