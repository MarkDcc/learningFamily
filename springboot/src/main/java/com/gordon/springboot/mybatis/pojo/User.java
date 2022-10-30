package com.gordon.springboot.mybatis.pojo;

import lombok.*;

import java.io.Serializable;

/**
 * @author dongchen
 * @Data 2022/9/8
 * @Time 22:01
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String sex;
    private String email;

}