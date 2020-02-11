package com.kipa.test.service.mq;

import com.kipa.mq.producer.MQProducerService;
import com.kipa.test.base.TestNGSpringContextTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

/**
 * 消息发送方 生产者
 */
public class ProducerServiceTest extends TestNGSpringContextTests {

    @Autowired
    private MQProducerService mqProducerService;

    @Test
    public void testSend() {
        for (int i = 0; i < 10; i++) {
            mqProducerService.send("這里是MQ的世界======"+i,"HelloTopic","TagC");
        }
    }
}
