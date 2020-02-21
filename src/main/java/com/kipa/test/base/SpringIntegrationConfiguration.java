package com.kipa.test.base;

import com.kipa.base.BaseSpringIntegrationConfiguration;
import com.kipa.config.EnableElasticJob;
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
//1. 业务默认的数据配置文件
@PropertySource(value = "classpath:config/business.properties")
//2. 业务默认的环境： application.properties
@EnableEnvironmentSwitch(env = EnvironmentType.TEST)
//3. 多数据源并行操作
@EnableMultipleDataSource(env = {EnvFlag.ENV1,EnvFlag.ENV2,EnvFlag.ENV3})
//4. 开启Redis 单例模式的redis
@EnableRedis(model = RedisModel.STAND_ALONE)
//5. 开启消息功能
@EnableRocketMQ(listenerScanPackage = "com.kipa.test.service.mq")
//6. 开启定时任务
@EnableElasticJob
public class SpringIntegrationConfiguration extends BaseSpringIntegrationConfiguration {
}
