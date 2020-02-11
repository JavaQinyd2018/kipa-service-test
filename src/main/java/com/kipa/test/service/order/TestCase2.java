package com.kipa.test.service.order;

import com.kipa.base.BasicTestNGSpringContextTests;
import com.kipa.common.run.TestCase;
import com.kipa.test.utils.PrintUtils;
import org.testng.annotations.Test;

/**
 * @author Qinyadong
 * @date 2019/7/11 17:53
 * @desciption
 * @since
 */
@TestCase(order = 2)
public class TestCase2 extends BasicTestNGSpringContextTests {

    @Test(description = "测试用例2")
    public void test2() {
        PrintUtils.println("==========我是test2，我在第二个===========");
    }
}
