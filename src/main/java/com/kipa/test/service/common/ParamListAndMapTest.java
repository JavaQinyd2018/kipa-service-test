package com.kipa.test.service.common;

import com.kipa.common.ParamList;
import com.kipa.common.ParamMap;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 构建list map
 */
public class ParamListAndMapTest {

    //构建list，默认创建的是一个ArrayList，把数据add到里面去
    @Test
    public void testBuildList() {
        List<String> list = ParamList.<String>newList().add("ok").add("yes").add("hello").add("good").build();
        System.out.println(list);
    }

    //构建list，自己创建一个ArrayList，把数据add到里面去
    @Test
    public void testBuildList2() {
        List<String> list = ParamList.newList(new ArrayList<String>()).add("ok").add("yes").add("hello").add("good").build();
        System.out.println(list);
    }

    @Test
    public void testBuildMap() {
        Map<String, String> map = ParamMap.<String, String>newMap()
                .put("username", "jmeas")
                .put("password", "456789")
                .put("passwordAgain", "456789")
                .put("phone", "11111111")
                .put("userType", "CUSTOMER")
                .build();
        System.out.println(map);
    }

    @Test
    public void testBuildMap2() {
        Map<String, String> map = ParamMap.newMap(new HashMap<String, String>(5))
                .put("username", "jmeas")
                .put("password", "456789")
                .put("passwordAgain", "456789")
                .put("phone", "11111111")
                .put("userType", "CUSTOMER")
                .build();
        System.out.println(map);
    }
}
