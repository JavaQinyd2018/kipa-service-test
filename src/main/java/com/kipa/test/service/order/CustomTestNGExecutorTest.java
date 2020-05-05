package com.kipa.test.service.order;

import com.kipa.common.run.TestNGDiscovery;
import com.kipa.common.run.TestNGExecutor;
import com.kipa.test.base.TestNGSpringContextTests;

/**
 * 定制TestNG的执行器
 * 执行com.kipa.test.service.run目录下面的用例
 * 通过包扫描的方式
 */
public class CustomTestNGExecutorTest {

    public static void main(String[] args) {
        TestNGDiscovery discovery = TestNGDiscovery
                .builder()
                .selectPackage("com.kipa.test.service.run")
                .build();
        TestNGExecutor<TestNGSpringContextTests> testNGExecutor = new TestNGExecutor<>(TestNGSpringContextTests.class);
        testNGExecutor.executeClass(discovery);
        //正常执行退出
        System.exit(0);
    }
}
