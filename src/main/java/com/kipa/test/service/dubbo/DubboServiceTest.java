package com.kipa.test.service.dubbo;

import com.alibaba.dubbo.remoting.exchange.ResponseCallback;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.kipa.base.BasicTestNGSpringContextTests;
import com.kipa.dubbo.excute.DubboRequest;
import com.kipa.dubbo.excute.DubboResponse;
import com.kipa.dubbo.service.DubboService;
import com.kipa.test.utils.PrintUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.Map;

/**
 *
 */
public class DubboServiceTest extends BasicTestNGSpringContextTests {

    @Autowired
    DubboService dubboService;
    @Test
    public void testSyncParam() {
        Map<String, Object> paramMap = Maps.newHashMap();
        paramMap.put(String.class.getName(),"15101287330");
        String result = dubboService.invoke("com.learn.springboot.springbootssmp.dubbo.UserInfoDubboService", "queryUserInfoByPhoneNo", paramMap);
        PrintUtils.println(result);
    }

    @Test
    public void testSyncParam2() {
        DubboRequest dubboRequest = DubboRequest.builder()
                .interfaceName("com.learn.springboot.springbootssmp.dubbo.UserInfoDubboService")
                .methodName("queryUserInfoByPhoneNo")
                .add(String.class.getName(), "15101287330")
                .build();
        DubboResponse dubboResponse = dubboService.invoke(dubboRequest);
        PrintUtils.println(dubboResponse.toString());
    }

    @Test
    public void testSyncObject() {
        String json = "{\"phone\":\"15101287330\",\"email\":\"qinyadong@huawei.com\"}";
        Map<String, Object> paramMap = Maps.newHashMap();
        paramMap.put("com.learn.springboot.springbootssmp.ro.UserRo", JSONObject.parseObject(json));
        String result = dubboService.invoke("com.learn.springboot.springbootssmp.dubbo.UserInfoDubboService", "getInfo", paramMap);
        PrintUtils.println(result);
    }

    @Test
    public void testSyncObject2() {
        Map<String, Object> request = Maps.newHashMap();
        request.put("phone","15101287330");
        request.put("email","qinyadong@huawei.com");
        Map<String, Object> paramMap = Maps.newHashMap();
        paramMap.put("com.learn.springboot.springbootssmp.ro.UserRo", request);
        String result = dubboService.invoke("com.learn.springboot.springbootssmp.dubbo.UserInfoDubboService", "getInfo", paramMap);
        PrintUtils.println(result);
    }



    @Test
    public void testAsyncParam() {
        Map<String, Object> paramMap = Maps.newHashMap();
        paramMap.put(String.class.getName(),"15101287330");
        dubboService.asyncInvoke(
                "com.learn.springboot.springbootssmp.dubbo.UserInfoDubboService",
                "queryUserInfoByPhoneNo",
                paramMap, new ResponseCallback() {
                    @Override
                    public void done(Object o) {
                        System.out.println("==============done=============");
                        System.out.println("==========result========="+o);
                    }

                    @Override
                    public void caught(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
    }

    @Test
    public void testAsyncParam1() {
        DubboRequest dubboRequest = DubboRequest.builder()
                .interfaceName("com.learn.springboot.springbootssmp.dubbo.UserInfoDubboService")
                .methodName("queryUserInfoByPhoneNo")
                .add(String.class.getName(), "15101287330")
                .build();
        DubboResponse dubboResponse = dubboService.asyncInvoke(dubboRequest, new ResponseCallback() {
            @Override
            public void done(Object o) {
                System.out.println("=======================done=====================");
                PrintUtils.println(o);
            }

            @Override
            public void caught(Throwable throwable) {

            }
        });
    }

    @Test
    public void testAsyncParam2() {
        Map<String, Object> request = Maps.newHashMap();
        request.put("phone","15101287330");
        request.put("email","qinyadong@huawei.com");

        DubboRequest dubboRequest = DubboRequest.builder()
                .interfaceName("com.learn.springboot.springbootssmp.dubbo.UserInfoDubboService")
                .methodName("getInfo")
                .add("com.learn.springboot.springbootssmp.ro.UserRo",request)
                .build();
        DubboResponse dubboResponse = dubboService.asyncInvoke(dubboRequest, new ResponseCallback() {
            @Override
            public void done(Object o) {
                System.out.println("==============="+o);
            }

            @Override
            public void caught(Throwable throwable) {

            }
        });
    }


    @Test
    public void testDirectLinkParam1() {
        DubboRequest dubboRequest = DubboRequest.builder()
                .interfaceName("com.learn.springboot.springbootssmp.dubbo.UserInfoDubboService")
                .methodName("queryUserInfoByPhoneNo")
                .add(String.class.getName(), "15101287330")
                .directUrl("dubbo://")
                .build();
        DubboResponse dubboResponse = dubboService.directedInvoke(dubboRequest);
        PrintUtils.println(dubboResponse.toString());
    }
}
