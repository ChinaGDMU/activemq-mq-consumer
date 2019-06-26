package cn.damon.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

/**
 * damon
 */
@Configuration
public class JmsConfig {

    public final static String MESSAGE1 = "cn.damon.message1";

    @Bean
    public Queue message1Queue() {
        return new ActiveMQQueue(MESSAGE1);
    }

}
