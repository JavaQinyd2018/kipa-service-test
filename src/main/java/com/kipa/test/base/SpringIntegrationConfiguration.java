package com.kipa.test.base;

import com.kipa.base.BaseSpringIntegrationConfiguration;
import com.kipa.config.EnableMultipleDataSource;
import com.kipa.config.EnableRedis;
import com.kipa.config.EnableRocketMQ;
import com.kipa.env.EnableEnvironmentSwitch;
import com.kipa.env.EnvironmentType;
import com.kipa.mybatis.service.condition.EnvFlag;
import com.kipa.redis.RedisModel;
import org.springframework.context.annotation.PropertySource;

/**
 * @author qinyadong
 * 自定义spring的配置类
 */
//业务默认的数据配置文件
@PropertySource(value = "classpath:config/business.properties")
//业务默认的环境： application.properties
@EnableEnvironmentSwitch(env = EnvironmentType.TEST)
@EnableMultipleDataSource(env = {EnvFlag.ENV1,EnvFlag.ENV2,EnvFlag.ENV3})
//@EnableRedis(model = RedisModel.STAND_ALONE)
//@EnableRocketMQ(listenerScanPackage = "com.kipa.test.service.mq")
public class SpringIntegrationConfiguration extends BaseSpringIntegrationConfiguration {
}
