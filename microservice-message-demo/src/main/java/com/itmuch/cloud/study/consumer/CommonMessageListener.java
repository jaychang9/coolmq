package com.itmuch.cloud.study.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author zhangjie
 * @package com.itmuch.cloud.study.consumer
 * @description TODO
 * @create 2018-10-10 10:24
 */
@Component
public class CommonMessageListener {
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "xxx", durable = "true", autoDelete = "false"),
            exchange = @Exchange(value = "spring-boot-exchange-1", type = ExchangeTypes.TOPIC),
            key = "spring-boot-exchange-1"

    ))
    public void receive(byte[] content) {
        System.out.println(new Date()+" receiverd " + new String(content));
    }
}
