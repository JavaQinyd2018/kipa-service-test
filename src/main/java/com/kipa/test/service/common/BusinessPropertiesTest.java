package com.kipa.test.service.common;

import com.kipa.base.BasicTestNGSpringContextTests;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;

public class BusinessPropertiesTest extends BasicTestNGSpringContextTests {

    @Value("${account.web.register.url}")
    private String registerUrl;

    @Test
    public void test() {
        System.out.println(registerUrl);
    }
}
