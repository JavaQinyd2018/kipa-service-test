package com.kipa.test.service.hello;

import com.kipa.test.base.TestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * 框架自定义基类的 的Hello World测试类
 */
public class CustomHelloWorldTest extends TestNGSpringContextTests {

    @Test
    public void customHelloWorld() {
        System.out.println("custom kipa-service, hello world.........");
    }
}
