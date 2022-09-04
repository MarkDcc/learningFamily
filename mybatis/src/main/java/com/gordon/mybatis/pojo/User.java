package com.gordon.mybatis.pojo;

import lombok.*;

/**
 * @author dongchen
 * @Data 2022/9/1
 * @Time 22:23
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String sex;
    private String email;

}
