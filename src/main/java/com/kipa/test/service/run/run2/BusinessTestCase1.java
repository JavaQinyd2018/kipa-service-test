package com.kipa.test.service.run.run2;

import com.kipa.common.run.TestCase;
import com.kipa.test.base.TestNGSpringContextTests;
import com.kipa.test.utils.PrintUtils;
import org.testng.annotations.Test;

@TestCase(order = 1)
public class BusinessTestCase1 extends TestNGSpringContextTests {

    @Test
    public void test1() {
        PrintUtils.println("========run2下面的===BusinessTestCase1的这里是测试方法一===========");
    }
}
