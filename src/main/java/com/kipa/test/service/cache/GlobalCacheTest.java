package com.kipa.test.service.cache;

import com.kipa.base.BasicTestNGSpringContextTests;
import com.kipa.data.ehcache.GlobalCacheContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

/**
 * 对框架的全局缓存进行操作
 */
public class GlobalCacheTest extends BasicTestNGSpringContextTests {

    @Autowired
    private GlobalCacheContext cacheContext;

    @Test
    public void test() {
        cacheContext.setAttribute("zhangsan","张三是个王八蛋");
    }

    @Test(dependsOnMethods = "test")
    public void test2() {
        Object zhangsan = cacheContext.getAttribute("zhangsan");
        System.out.println(zhangsan);
        System.out.println(cacheContext.getAttribute("common.hello.world"));
    }
}
