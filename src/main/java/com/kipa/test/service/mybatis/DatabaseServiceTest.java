package com.kipa.test.service.mybatis;

import com.google.common.collect.Maps;
import com.kipa.base.BasicTestNGSpringContextTests;
import com.kipa.common.ParamMap;
import com.kipa.mybatis.service.impl.DatabaseService;
import com.kipa.test.utils.PrintUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.*;

/**
 * DatabaseService的增刪改查 基本操作
 */
public class DatabaseServiceTest extends BasicTestNGSpringContextTests {

    @Autowired
    private DatabaseService databaseService;

    @Test
    public void test() {
        Map<String, Object> map = databaseService.selectOne("tb_user", Arrays.asList("username='kobe'", "id = 1"));
        PrintUtils.println(map);
    }

    @Test
    public void test1() {
        Map<String,Object> map = Maps.newHashMap();
        map.put("id",1);
        map.put("username","kobe");
        Map<String, Object> resultMap = databaseService.selectOne("tb_user", map);
        PrintUtils.println(resultMap);
    }

    @Test
    public void test2() {
        Map<String, Object> map = databaseService.selectOne("select * from tb_user where username = 'kobe' and id = 1");
        PrintUtils.println(map);
    }

    @Test
    public void test3() {
        List<Map<String, Object>> list = databaseService.selectList("tb_user", Arrays.asList("password = '123456'", "phone = '141414141'"));
        PrintUtils.println(list);
    }

    @Test
    public void test4() {
        Map<String,Object> map = Maps.newHashMap();
        map.put("password",123456);
        map.put("phone","141414141");
        List<Map<String, Object>> list = databaseService.selectList("tb_user", map);
        PrintUtils.println(list);
    }

    @Test
    public void test5() {
        List<Map<String, Object>> list = databaseService.selectList("select * from tb_user where password = '123456' and phone = '141414141'");
        PrintUtils.println(list);
    }

    @Test
    public void test6() {
        List<Map<String, Object>> list = databaseService.selectColumn("tb_user",
                Arrays.asList("username","password","created", "updated"),
                Arrays.asList("phone = '15101287330'"));
        PrintUtils.println(list);
    }

    @Test
    public void test7() {
        Map<String,Object> map = Maps.newHashMap();
        map.put("phone","15101287330");
        List<Map<String, Object>> list = databaseService.selectColumn("tb_user",
                Arrays.asList("username", "password", "created", "updated"),
                map);
        PrintUtils.println(list);
    }

    @Test
    public void test8() {
        Long count = databaseService.count("tb_user", Arrays.asList("phone = '15101287330'"));
        PrintUtils.println(count);
    }

    @Test
    public void test9() {
        Map<String,Object> map = Maps.newHashMap();
        map.put("password",123456);
        map.put("phone","141414141");
        Long count = databaseService.count("tb_user", map);
        PrintUtils.println(count);
    }

    @Test
    public void test10() {
        Map<String,Object> map = Maps.newHashMap();
        map.put("password",123456);
        map.put("phone","141414141");
        List<Map<String, Object>> list = databaseService.selectPage("tb_user", map, 1, 2);
        PrintUtils.println(list);
    }

    @Test
    public void test11() {
        List<Map<String, Object>> list = databaseService.selectPage("tb_user", Arrays.asList("password='123456'", "phone='141414141'"), 2, 1);
        PrintUtils.println(list);
    }

    @Test
    public void test12() {
        Map<String, Object> map = Maps.newLinkedHashMap();
        map.put("username","mybatis");
        map.put("password","123456");
        map.put("phone","1234567890");
        map.put("email","mybatis@123.com");
        map.put("created",new Date());
        map.put("updated",new Date());
        int result = databaseService.insert("tb_user", map);
        PrintUtils.println(result);
    }

    @Test
    public void test13() {
        String sql = "insert into tb_user(username,password,phone,email,created,updated) values('mysql','456789','797328323232','123@123.com',now(),now())";
        int result = databaseService.insert(sql);
        PrintUtils.println(result);
    }

    @Test
    public void test14() {
        String csvFilePath = "data/service/Test2.csv";
        int result = databaseService.batchInsert("tb_user", csvFilePath);
        PrintUtils.println(result);
    }

    @Test
    public void test15() {
        Map<String, Object> map = Maps.newLinkedHashMap();
        map.put("username","book");
        map.put("password","123456");
        map.put("phone","67236726323");
        map.put("email","book@123.com");
        Map<String, Object> map1 = Maps.newLinkedHashMap();
        map1.put("phone","1234567890");
        map1.put("email","mybatis@123.com");
        int result = databaseService.update("tb_user", map, map1);
        PrintUtils.println(result);
    }


    @Test
    public void test16() {
        int result = databaseService.update("tb_user", Arrays.asList("phone='68136813131'", "email='hello@123.com'"),
                Arrays.asList("username='book'", "password='123456'"));
        PrintUtils.println(result);
    }

    @Test
    public void test17() {
        int update = databaseService.update("update tb_user set password='123456' where username = 'oracle4'");
        PrintUtils.println(update);
    }

    @Test
    public void test18() {
        Map<String, Object> map = Maps.newLinkedHashMap();
        map.put("username","oracle5");
        int result = databaseService.delete("tb_user", map);
        PrintUtils.println(result);
    }

    @Test
    public void test19() {
        int result = databaseService.delete("tb_user", Arrays.asList("username = 'oracle7'"));
        PrintUtils.println(result);
    }

    @Test
    public void test20() {
        int result = databaseService.delete ("delete from tb_user where username = 'oracle6'");
        PrintUtils.println(result);
    }

    @Test
    public void test22() {
        Map<String, Object> param = ParamMap.<String, Object>newMap()
                .put("username", "mybatis")
                .put("phone", "1234567890")
                .put("phone","891379183131")
                .put("email","mybatis@123.com")
                .put("created",new Date())
                .put("updated",new Date())
                .build();
        Map<String, Object> map = databaseService.selectOne("tb_user", param);
        PrintUtils.println(map);
    }

    @Test
    public void test23() {
        Map<String, Object> param = ParamMap.newMap(new HashMap<String, Object>())
                .put("username", "mybatis")
                .put("phone", "1234567890")
                .build();
        Map<String, Object> map = databaseService.selectOne("tb_user", param);
        PrintUtils.println(map);
    }

}
