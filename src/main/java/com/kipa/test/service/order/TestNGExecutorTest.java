package com.kipa.test.service.order;

import com.kipa.common.run.TestNGDiscovery;
import com.kipa.common.run.TestNGExecutor;
import org.testng.annotations.Test;

public class TestNGExecutorTest {

    @Test
    public void test() {
        TestNGDiscovery discovery = TestNGDiscovery.builder()
                .selectPackage("com.kipa.test.service.order")
                .build();
        TestNGExecutor executor = new TestNGExecutor();
        executor.execute(discovery);
    }
}
