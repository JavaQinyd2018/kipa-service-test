package com.kipa.test.service.order;

import com.kipa.base.BasicTestNGSpringContextTests;
import com.kipa.common.run.TestCase;
import com.kipa.data.DataParam;
import com.kipa.mock.http.annotation.MockHttp;
import com.kipa.test.utils.PrintUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Qinyadong
 * @date 2019/7/11 17:53
 * @desciption
 * @since
 */
@TestCase(order = 1)
public class TestCase1 extends BasicTestNGSpringContextTests {

    @Test(description = "测试用例1")
    public void test1() {
        PrintUtils.println("==========我是test1，我在第一个===========");
    }
}
