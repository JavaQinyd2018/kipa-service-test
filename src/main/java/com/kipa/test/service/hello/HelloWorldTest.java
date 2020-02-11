package com.kipa.test.service.hello;

import com.kipa.base.BasicTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * hello world入门测试类
 * 检测环境配置 默认加载resources目录下面的application.properties
 */
public class HelloWorldTest extends BasicTestNGSpringContextTests {

    @Test
    public void helloWorld() {
        System.out.println("kipa-service, hello world......");
    }
}
