package com.kipa.test.service.run.run1;

import com.kipa.common.run.TestCase;
import com.kipa.test.base.TestNGSpringContextTests;
import com.kipa.test.utils.PrintUtils;
import org.testng.annotations.Test;

@TestCase(order = 2)
public class BusinessTestCase2 extends TestNGSpringContextTests {

    @Test
    public void test2() {
        PrintUtils.println("====run1下面的=======BusinessTestCase2==的这里是测试方法二===========");
    }
}
