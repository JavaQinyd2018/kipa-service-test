package com.kipa.test.service.order;

import com.kipa.base.BasicTestNGSpringContextTests;
import com.kipa.common.run.TestCase;
import com.kipa.test.utils.PrintUtils;
import org.testng.ITestContext;
import org.testng.annotations.Test;

/**
 * @author Qinyadong
 * @date 2019/8/13 23:01
 * @desciption
 * @since
 */
@TestCase(order = 3)
public class TestCase3 extends BasicTestNGSpringContextTests {

    @Test
    public void test3() {
        PrintUtils.println("==========我是test3，我在第三个===========");
    }

}
