package com.kipa.test.service.redis;

import com.kipa.test.base.TestNGSpringContextTests;
import com.kipa.test.utils.PrintUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.testng.annotations.Test;

/**
 * redis操作， 通过普通的Spring redis的整合的整合类进行测试
 */
public class RedisTest extends TestNGSpringContextTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() {
        PrintUtils.println(stringRedisTemplate.opsForValue().get("HELLO_CONSOLE_HELLO_PRIVILEGE_212"));
        PrintUtils.println(redisTemplate.opsForValue().get("HELLO_LEND_FILE_DOWNLOAD_EXCEPTION"));
    }
}
