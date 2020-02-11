package com.kipa.test.base;

import com.kipa.base.BaseTestNGSpringContextTests;
import com.kipa.base.BasicSpringIntegrationConfiguration;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author Qinyadong
 * <p> 自定义的测试入口类</p>
 */
@ContextConfiguration(classes = {SpringIntegrationConfiguration.class})
public class TestNGSpringContextTests extends BaseTestNGSpringContextTests {

}
