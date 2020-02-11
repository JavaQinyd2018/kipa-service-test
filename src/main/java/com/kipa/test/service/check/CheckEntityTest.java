package com.kipa.test.service.check;

import com.google.common.collect.Lists;
import com.kipa.check.CheckHelper;
import org.testng.annotations.Test;

import java.util.List;

/**
 * 实体类校验
 */
public class CheckEntityTest {

    @Test
    public void testCheckEntity() {
        User user1 = User.builder().age(10).address("nanjing").username("pual").success(false).build();
        User user2 = User.builder().age(10).address("shanghai").username("kobe").success(true).build();
        User user3 = User.builder().age(10).address("shanghai").username("kobe").success(true).build();
        User user4 = User.builder().age(12).address("beijing").username("jordan").success(false).build();
        List<User> userList = Lists.newArrayList();
        userList.add(user1);
        userList.add(user2);

        List<User> userList1 = Lists.newArrayList();
        userList1.add(user3);
        userList1.add(user4);

//        CheckHelper.checkEntityEquals(user1, user2, "对象不相等");
        CheckHelper.checkEntityEquals(userList, userList1, "集合不相等");
    }
}
