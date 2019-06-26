package cn.damon.web;

import cn.damon.config.JMSProducer;
import cn.damon.config.JmsConfig;
import cn.damon.model.People;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ProduceController
 * @Description
 * @Author Zhou Daoming
 * @Date 2019/6/26 16:35
 * @Email zdmsjyx@163.com
 * @Version 1.0
 */
@RestController
@RequestMapping("/produce")
public class ProduceController {

    @Autowired
    private JMSProducer jmsProducer;

    @GetMapping("/sendMsg")
    public String sendMsg(@RequestParam(value = "name") String name,@RequestParam(value = "age")  Integer age){
        People people = new People();
        people.setName(name);
        people.setAge(age);
        jmsProducer.sendQueueMessage(JmsConfig.MESSAGE1, JSONObject.toJSONString(people));
        return "send successfully!";
    }
}
