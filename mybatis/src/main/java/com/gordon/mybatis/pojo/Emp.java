package com.gordon.mybatis.pojo;

import lombok.*;

/**
 * @author dongchen
 * @Data 2022/9/3
 * @Time 16:23
 */
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    private Integer id;
    private String empName;
    private Integer age;
    private String sex;
    private String email;
    private Dept dept;
}
