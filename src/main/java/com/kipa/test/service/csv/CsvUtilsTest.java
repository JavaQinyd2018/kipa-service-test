package com.kipa.test.service.csv;

import com.kipa.data.csv.CSVType;
import com.kipa.data.csv.CSVUtils;
import com.kipa.mock.http.service.bo.MockParamRequest;
import com.kipa.mock.http.service.bo.MockResponse;
import com.kipa.test.utils.PrintUtils;
import org.testng.annotations.Test;

import java.util.List;

/**
 * CSVUtils工具测试类
 */
public class CsvUtilsTest {

    @Test
    public void test() {
        CSVUtils.createCsvFile(MockParamRequest.class, "data/mock/MockParamRequest_1.csv", CSVType.VERTICAL);
        CSVUtils.createCsvFile(MockResponse.class,"data/mock/MockResponse_1.csv",CSVType.TRANSVERSE);
        CSVUtils.createCsvFile(MockResponse.class,"data/mock/MockResponse_2.csv",CSVType.CHECK_DB);
    }


    @Test
    public void test2() {
        MockResponse response = CSVUtils.convert2Bean(MockResponse.class, "data/mock/MockResponse_4.csv", 4, CSVType.TRANSVERSE);
        MockResponse response1 = CSVUtils.convert2Bean(MockResponse.class, "data/mock/MockResponse_3.csv", 2, CSVType.VERTICAL);
        List<MockParamRequest> mockParamRequests = CSVUtils.convert2BeanList(MockParamRequest.class, "data/mock/mockParamRequest.csv", CSVType.VERTICAL);
        PrintUtils.println(response);
        PrintUtils.println(response1);
        PrintUtils.println(mockParamRequests);
    }


}
