package com.kipa.test.service.csv;

import com.kipa.base.BasicTestNGSpringContextTests;
import com.kipa.data.DataParam;
import com.kipa.test.utils.PrintUtils;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 数据驱动测试类
 */
public class DataProviderTest extends BasicTestNGSpringContextTests {

    //默认读取类名+方法名下面的csv文件信息，进行数据驱动
    @Test(dataProvider = "csv")
    public void testDefault(String username,
                            String address,
                            Long phone,
                            String email,
                            Date createDate,
                            java.sql.Date updateDate,
                            int index,
                            BigDecimal price) {
        PrintUtils.println(username, address, phone, email, createDate, updateDate, index, price);
    }

    @Test(dataProvider = "csv")
    @DataParam(paramName ="dataFile",paramValue = "data/service/Test.csv")
    public void testAnnotation(String username,
                     String address,
                     Long phone,
                     String email,
                     Date createDate,
                     java.sql.Date updateDate,
                     int index,
                     BigDecimal price) {
        PrintUtils.println(username, address, phone, email, createDate, updateDate, index, price);
    }



}
