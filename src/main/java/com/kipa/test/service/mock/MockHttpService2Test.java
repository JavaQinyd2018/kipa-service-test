package com.kipa.test.service.mock;

import com.google.common.collect.Maps;
import com.kipa.base.BasicTestNGSpringContextTests;
import com.kipa.http.service.impl.HttpService;
import com.kipa.mock.http.service.MockService;
import com.kipa.mock.http.service.bo.MockParamRequest;
import com.kipa.mock.http.service.bo.MockResponse;
import com.kipa.test.utils.PrintUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * mock 无数据驱动的方式
 */
public class MockHttpService2Test extends BasicTestNGSpringContextTests {

    @Autowired
    private MockService mockService;

    @BeforeMethod
    public void before() {

        MockParamRequest mockParamRequest = MockParamRequest.builder()
                .path("/hello")
                .method("get")
                .addHeader("accept", "application/json;charset=utf-8")
                .addRequestParam("username", "kobe")
                .build();
        MockResponse mockResponse = MockResponse.builder()
                .statusCode(200)
                .addHeader("accept", "application/json;charset=utf-8")
                .body("{\"phone\":\"15101287330\",\"created\":\"1234-09-14\",\"id\":1,\"username\":\"kobe\"}")
                .build();
        mockService.mockResponse(mockParamRequest, mockResponse);
    }

    @Autowired
    private HttpService httpService;

    @Test
    public void test() {
        Map<String, String> headerMap = Maps.newHashMap();
        headerMap.put("accept","application/json;charset=utf-8");
        String s = httpService.get("http://127.0.0.1:6231/hello?username=kobe",headerMap, true);
        PrintUtils.println(s);
    }

}
