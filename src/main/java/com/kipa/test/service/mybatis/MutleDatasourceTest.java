package com.kipa.test.service.mybatis;

import com.kipa.mybatis.service.impl.*;
import com.kipa.test.base.TestNGSpringContextTests;
import com.kipa.test.utils.PrintUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * @author: Qinyadong
 * @date: 2019/6/21 22:28
 * @since:
 */
public class MutleDatasourceTest extends TestNGSpringContextTests {

    @Autowired
    private DatabaseService databaseService;

    @Autowired
    private DatabaseService1 databaseService1;

    @Autowired
    private DatabaseService2 databaseService2;

    @Autowired
    private DatabaseService3 databaseService3;


    @Test
    public void test() {
        //test
        Map<String, Object> map = databaseService.selectOne("select * from tb_user where id = 1");
        PrintUtils.println(map);

        //mybatis plus
        Map<String, Object> map1 = databaseService1.selectOne("select * from user where id = 1");
        PrintUtils.println(map1);

        //51shopping
        Map<String, Object> map2 = databaseService2.selectOne("select * from tb_user where id = 1");
        PrintUtils.println(map2);

        //mybatis plus
        Map<String, Object> map3 = databaseService3.selectOne("select * from user where id = 1");
        PrintUtils.println(map3);
    }


}
