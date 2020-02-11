package com.kipa.test.service.mock;

import com.kipa.base.BasicTestNGSpringContextTests;
import com.kipa.data.DataMeta;
import com.kipa.data.DataParam;
import com.kipa.data.csv.CSVType;
import com.kipa.data.csv.CSVUtils;
import com.kipa.http.service.impl.HttpService;
import com.kipa.mock.http.annotation.MockHttp;
import com.kipa.mock.http.service.MockService;
import com.kipa.mock.http.service.bo.MockParamRequest;
import com.kipa.mock.http.service.bo.MockResponse;
import com.kipa.test.base.TestNGSpringContextTests;
import com.kipa.test.utils.PrintUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

/**
 * HttpMock 测试
 */
public class MockHttpServiceTest extends BasicTestNGSpringContextTests {

    @Autowired
    private MockService mockService;

    @Autowired
    private HttpService httpService;


    @MockHttp
    @DataMeta({
            @DataParam(paramName = "requestCsvFile",paramValue = "data/mock/httpMockParamRequest.csv"),
            @DataParam(paramName = "responseCsvFile",paramValue = "data/mock/httpMockResponse.csv")
    })
    public void mock(String requestCsvFile, String responseCsvFile) {
        MockParamRequest request = CSVUtils.convert2Bean(MockParamRequest.class,requestCsvFile, 0, CSVType.VERTICAL);
        MockResponse response = CSVUtils.convert2Bean(MockResponse.class, responseCsvFile,0,CSVType.VERTICAL);
        mockService.mockResponse(request, response);
    }

    //默认读取 testMock（当前方法）目录下面的MockHttpServiceTest.testMock.csv（当前类.当前方法.csv）文件
    @Test(dataProvider = "csv")
    public void testMock(String url,String path,String name, String value) {
        System.out.println("=================测试=================");
        String s = httpService.get(String.format("%s%s?%s=%s",url, path, name, value), true);
        PrintUtils.println(s);
    }

}
