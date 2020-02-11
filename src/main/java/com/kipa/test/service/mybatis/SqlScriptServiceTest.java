package com.kipa.test.service.mybatis;

import com.kipa.base.BasicTestNGSpringContextTests;
import com.kipa.mybatis.service.SqlScriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

/**
 * 批量执行sql脚本
 */
public class SqlScriptServiceTest extends BasicTestNGSpringContextTests {

    @Autowired
    private SqlScriptService sqlScriptService;

    @Test
    public void executeSql() {
        //sql脚本
        String sql = "data/sql/user.sql";
        sqlScriptService.executeSqlScript(sql);
    }
}
