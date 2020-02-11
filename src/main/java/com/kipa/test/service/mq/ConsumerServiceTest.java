package com.kipa.test.service.mq;

import com.kipa.mq.consumer.RocketMQListener;
import com.kipa.mq.consumer.Subscribe;
import com.kipa.test.utils.PrintUtils;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.nio.charset.StandardCharsets;

/**
* 消息消费者测试
 */
@RocketMQListener(topic = "TestTopic",consumePosition = ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET)
public class ConsumerServiceTest {

    /**
     * 具体订阅的方法
     * @param message
     */
    @Subscribe(tag = "TagA",messageType = String.class)
    public void test1(String message) {
        PrintUtils.println("=============="+message+"===============");
    }

    @Subscribe(tag = "TagA",messageType =MessageExt.class)
    public void test2(MessageExt message) {
        PrintUtils.println("====="+message.getMsgId()+"========="+new String(message.getBody(), StandardCharsets.UTF_8)+"===============");
    }
}
