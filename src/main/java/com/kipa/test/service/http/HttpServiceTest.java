package com.kipa.test.service.http;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.kipa.base.BasicTestNGSpringContextTests;
import com.kipa.http.service.impl.HttpService;
import com.kipa.test.base.TestNGSpringContextTests;
import com.kipa.test.utils.PrintUtils;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Map;

/**
 * HttpService 测试类
 */
public class HttpServiceTest extends BasicTestNGSpringContextTests {

    @Autowired
    private HttpService httpService;

    @Test
    public void testGet() {
        String s = httpService.get("http://localhost:8989/user/findById?id=1");
        PrintUtils.println(s);
    }


    @Test
    public void testGet1() {
        String s = httpService.get("http://localhost:8989/user/findById?id=1",true);
        PrintUtils.println(s);
    }

    @Test
    public void testGet2() {
        Map<String, String> headMap = Maps.newHashMap();
        headMap.put("Accept","application/json");

        Map<String, String> paramMap = Maps.newHashMap();
        paramMap.put("id","1");
        String json = httpService.get("http://localhost:8989/user/findById", headMap, paramMap, true);
        PrintUtils.println(json);
    }

    @Test
    public void testGet3() {
        Map<String, String> headMap = Maps.newHashMap();
        headMap.put("Accept","application/json");
        String json = httpService.get("http://localhost:8989/user/findById?id=1", headMap, true);
        PrintUtils.println(json);
    }

    @Test
    public void testPost() {
        Map<String, String> paramMap = Maps.newHashMap();
        paramMap.put("username","spring");
        paramMap.put("password","123456");
        paramMap.put("password2","123456");
        paramMap.put("email","spring@123.com");
        paramMap.put("phone","123456789");
        String json = JSON.toJSONString(paramMap);
        String result = httpService.post("http://localhost:8989/user/save", json);
        PrintUtils.println(result);
    }

    @Test
    public void testPost1() {
        Map<String, String> headMap = Maps.newHashMap();
        headMap.put("Accept","application/json");
        Map<String, String> paramMap = Maps.newHashMap();
        paramMap.put("username","spring");
        paramMap.put("password","123456");
        paramMap.put("password2","123456");
        paramMap.put("email","spring@123.com");
        paramMap.put("phone","123456789");
        String json = JSON.toJSONString(paramMap);
        String result = httpService.post("http://localhost:8989/user/save", headMap, json, true);
        PrintUtils.println(result);
    }

    @Test
    public void testPost2() {
        Map<String, String> paramMap = Maps.newHashMap();
        paramMap.put("username","spring");
        paramMap.put("password","123456");
        paramMap.put("password2","123456");
        paramMap.put("email","spring@123.com");
        paramMap.put("phone","123456789");
        String json = JSON.toJSONString(paramMap);
        String result = httpService.post("http://localhost:8989/user/save", json);
        PrintUtils.println(result);
    }

    @Test
    public void testPost3() {
        Map<String, String> paramMap = Maps.newHashMap();
        paramMap.put("username","spring");
        paramMap.put("password","123456");
        paramMap.put("password2","123456");
        paramMap.put("email","spring@123.com");
        paramMap.put("phone","123456789");
        String result = httpService.post("http://localhost:8989/user/save", paramMap);
        PrintUtils.println(result);
    }

    @Test
    public void testPost4() {
        Map<String, String> headMap = Maps.newHashMap();
        headMap.put("Accept","application/json");
        Map<String, String> paramMap = Maps.newHashMap();
        paramMap.put("username","spring");
        paramMap.put("password","123456");
        paramMap.put("password2","123456");
        paramMap.put("email","spring@123.com");
        paramMap.put("phone","123456789");
        String result = httpService.post("http://localhost:8989/user/save", headMap, paramMap, true);
        PrintUtils.println(result);
    }

    @Test
    public void testPost5() {
        Map<String, String> headMap = Maps.newHashMap();
        headMap.put("Accept","application/json");
        Map<String, String> paramMap = Maps.newHashMap();
        paramMap.put("username","spring");
        paramMap.put("password","123456");
        paramMap.put("password2","123456");
        paramMap.put("email","spring@123.com");
        paramMap.put("phone","123456789");
        String result = httpService.post("http://localhost:8989/user/save", headMap, paramMap, true);
        PrintUtils.println(result);
    }

    @Test
    public void testPut() {
        Map<String, String> headMap = Maps.newHashMap();
        headMap.put("Accept","application/json");
        Map<String, String> paramMap = Maps.newHashMap();
        paramMap.put("id","104");
        paramMap.put("username","root");
        paramMap.put("password","456123");
        paramMap.put("password2","456123");
        paramMap.put("email","root@123.com");
        paramMap.put("phone","4747474747");
        String jsonString = JSON.toJSONString(paramMap);
        String result = httpService.put("http://localhost:8989/user/update", headMap, jsonString, true);
        PrintUtils.println(result);
    }

    @Test
    public void testPut1() {
        Map<String, String> headMap = Maps.newHashMap();
        headMap.put("Accept","application/json");
        Map<String, String> paramMap = Maps.newHashMap();
        paramMap.put("id","104");
        paramMap.put("username","root");
        paramMap.put("password","456123");
        paramMap.put("password2","456123");
        paramMap.put("email","root@123.com");
        paramMap.put("phone","4747474747");
        String jsonString = JSON.toJSONString(paramMap);
        String json = httpService.put("http://localhost:8989/user/update", jsonString);
        PrintUtils.println(json);
    }

    @Test
    public void testPut2() {
        Map<String, String> headMap = Maps.newHashMap();
        headMap.put("Accept","application/json");
        Map<String, String> paramMap = Maps.newHashMap();
        paramMap.put("id","104");
        paramMap.put("username","root");
        paramMap.put("password","456123");
        paramMap.put("password2","456123");
        paramMap.put("email","root@123.com");
        paramMap.put("phone","4747474747");
        String jsonString = JSON.toJSONString(paramMap);
        String json = httpService.put("http://localhost:8989/user/update", jsonString,true);
        PrintUtils.println(json);
    }


    @Test
    public void testPut3() {
        Map<String, String> headMap = Maps.newHashMap();
        headMap.put("Accept","application/json");
        Map<String, String> paramMap = Maps.newHashMap();
        paramMap.put("id","104");
        paramMap.put("username","root");
        paramMap.put("password","456123");
        paramMap.put("password2","456123");
        paramMap.put("email","root@123.com");
        paramMap.put("phone","4747474747");
        String jsonString = JSON.toJSONString(paramMap);
        String json = httpService.put("http://localhost:8989/user/update", jsonString,true);
        PrintUtils.println(json);
    }

    @Test
    public void testDelete() {
        Map<String, String> paramMap = Maps.newHashMap();
        paramMap.put("ids","104,91,92,93");
        String result = httpService.post("http://localhost:8989/user/delete", paramMap, true);
        PrintUtils.println(result);
    }

    @Test
    public void test() throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();
        FormBody formBody = new FormBody.Builder().add("ids","104,91,92,93").build();
        Request request = new Request.Builder().url("http://localhost:8989/user/delete").delete(formBody).build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        assert response.body() != null;
        String string = response.body().string();
        PrintUtils.println("=================="+string+"==================");
    }

    //        Map<String, String> headMap = Maps.newHashMap();
    //        headMap.put("Accept","application/x-www-form-urlencoded");
    //        //application/x-www-form-urlencoded

    @Test
    public void testDelete1() {
        Map<String, String> headMap = Maps.newHashMap();
//        headMap.put("Accept","application/x-www-form-urlencoded");
        Map<String, String> paramMap = Maps.newHashMap();
        paramMap.put("ids","90,91");
        String result = httpService.delete("http://localhost:8989/user/delete", headMap, paramMap, true);
        PrintUtils.println(result);
    }

    @Test
    public void testInfo() {
        Map<String, String> paramMap = Maps.newHashMap();
        paramMap.put("info","hello world");
        String s = httpService.post("http://localhost:8989/user/info", paramMap);
        PrintUtils.println(s);
    }

    @Test
    public void testMap() {
        Map<String, String> paramMap1 = Maps.newHashMap();
        Map<String, String> paramMap = Maps.newHashMap();
        paramMap.put("info","hello world");
        paramMap.put("username","kobe");
        paramMap.put("age","20");
        paramMap1.put("paramMap",JSON.toJSONString(paramMap));
        String s = httpService.put("http://localhost:8989/user/map", paramMap1);
        PrintUtils.println(s);
    }

    @Test
    public void fileUpload() {
        Map<String, String> paramMap = Maps.newHashMap();
        paramMap.put("filePath","C:\\workspace\\WorkInfo\\hello\\notify.xml");
        paramMap.put("fileName","notify.xml");
        paramMap.put("fileType","xml");
        paramMap.put("mediaType","text/xml; charset=utf-8");
        Map<String, String> upload = httpService.upload("http://localhost:8989/user/upload", paramMap);
        PrintUtils.println(upload);
    }


    @Test
    public void testDown() {

        Map<String, String> headMap = Maps.newHashMap();
        headMap.put("Accept","application/json");
        Map<String, String> paramMap = Maps.newHashMap();
        paramMap.put("id","1");
        httpService.asyncGet("http://localhost:8989/user/findById", headMap, paramMap, (call, httpResponse) -> PrintUtils.println(httpResponse));
    }
}
