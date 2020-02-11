package com.kipa.test.service.order;

import com.kipa.base.BasicTestNGSpringContextTests;
import com.kipa.common.run.TestCase;
import com.kipa.test.utils.PrintUtils;
import org.testng.annotations.Test;

/**
 * @author Qinyadong
 * @date 2019/8/14 17:03
 * @desciption
 * @since
 */
@TestCase(order = 4)
public class TestCase4 extends BasicTestNGSpringContextTests {

    @Test
    public void test1() {
        PrintUtils.println("==========我是test4，我在第四个===========");
    }

}
