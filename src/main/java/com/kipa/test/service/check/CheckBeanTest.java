package com.kipa.test.service.check;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kipa.check.CheckHelper;
import com.kipa.data.csv.CSVType;
import com.kipa.data.csv.CSVUtils;
import com.kipa.mock.http.service.bo.MockParamRequest;
import org.apache.commons.io.FilenameUtils;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 校验任何一个Bean对象
 */
public class CheckBeanTest {

    /**
     * 测试 基础数据类型
     */
    @Test
    public void test() {
        CheckHelper.checkBeanEquals(new BigDecimal(2.13), new BigDecimal(2.13), "不相等");
        CheckHelper.checkBeanEquals(new Date(), new Date(), "错误");
        CheckHelper.checkBeanEquals('c','c', "错误");
        CheckHelper.checkBeanEquals(450L, 300L, "错误");
    }

    /**
     * 校验 List
     */
    @Test
    public void testList() {
        List<Map<String, Object>> list = Lists.newArrayList();
        Map<String, Object> map = Maps.newHashMap();
        map.put("username","kobe");
        map.put("phone","123456789");
        Map<String, Object> map3 = Maps.newHashMap();
        map3.put("username","kobe");
        map3.put("phone","1234567890");
        list.add(map);
        list.add(map3);
        List<Map<String, Object>> list1 = org.testng.collections.Lists.newArrayList();
        Map<String, Object> map1 = Maps.newHashMap();
        map1.put("username","kobe2");
        map1.put("phone","123456789");
        Map<String, Object> map4 = Maps.newHashMap();
        map4.put("username","kobe");
        map4.put("phone","123456789");
        list1.add(map1);
        list1.add(map4);
//        CheckHelper.checkBeanEquals(map, map1, "集合不相等");
        CheckHelper.checkBeanEquals(list, list1, "list不相等");
    }

    @Test
    public void testCheckBean() {
        String csv = "data/mock/MockParamRequest.csv";
        MockParamRequest request = CSVUtils.convert2Bean(MockParamRequest.class, csv, 0, CSVType.VERTICAL);
        MockParamRequest request1 = CSVUtils.convert2Bean(MockParamRequest.class, csv, 1, CSVType.VERTICAL);
        CheckHelper.checkBeanEquals(request, request1, "对象不相等");
    }

    @Test
    public void testCheckJSON() {
        String json = "{\"errorMsg\":\"请输入正确的验证码\",\"status\":1022}";
        JSONObject jsonObject = JSON.parseObject(json);
        JSONObject expectJson = new JSONObject();
        expectJson.put("errorMsg","验证码验证成功");
        expectJson.put("status",0);
        CheckHelper.checkBeanEquals(jsonObject, expectJson, "结果不匹配");
    }
}
