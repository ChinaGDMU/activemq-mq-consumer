package cn.damon.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * damon
 */
@Component
public class JMSConsumer {


    private final static Logger logger = LoggerFactory.getLogger(JMSConsumer.class);

    @JmsListener(destination = JmsConfig.MESSAGE1, containerFactory = "message1")
    public void message1Queue(String msg) {
        System.out.println("receive message:["+msg+"]");
    }



}
