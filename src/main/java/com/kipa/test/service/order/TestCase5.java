package com.kipa.test.service.order;

import com.kipa.base.BasicTestNGSpringContextTests;
import com.kipa.common.run.Step;
import com.kipa.common.run.TestCase;
import com.kipa.test.utils.PrintUtils;
import org.testng.annotations.Test;

/**
* @Step 测试类
 */
@TestCase(order = 5)
public class TestCase5 extends BasicTestNGSpringContextTests {

    @Step(order = 1,description = "第一步")
    @Test
    public void test1() {
        PrintUtils.println("第一步：准备信息");
    }

    @Step(order = 3,description = "第二步")
    @Test
    public void test2() {
        PrintUtils.println("第二步：调用接口");
    }

    @Step(order = 2,description = "第三步")
    @Test
    public void test3() {
        PrintUtils.println("第三步：数据校验");
    }
}
