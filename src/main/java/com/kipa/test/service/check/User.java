package com.kipa.test.service.check;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* 实体类
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String username;
    private boolean success;
    private Integer age;
    private String address;
}
