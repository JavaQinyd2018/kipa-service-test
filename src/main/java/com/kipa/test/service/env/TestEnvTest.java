package com.kipa.test.service.env;

import com.kipa.data.ehcache.GlobalCacheContext;
import com.kipa.test.base.TestNGSpringContextTests;
import com.kipa.test.utils.PrintUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

/**
 * 主要看是否有加载TestNGSpringContextTests的 @EnableMultipleDataSource
 * 开启的环境信息 eg. test环境对应 application-test.properties文件中的属性
 */
public class TestEnvTest extends TestNGSpringContextTests {

    @Autowired
    private GlobalCacheContext cacheContext;

    @Test
    public void test() {
        PrintUtils.println(cacheContext.getAttribute("common.hello.world"));
    }
}
