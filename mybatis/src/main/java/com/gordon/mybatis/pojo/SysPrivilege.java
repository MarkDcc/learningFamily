package com.gordon.mybatis.pojo;

import lombok.*;

/**
 * @Author:dongchen
 * @Date: 2022/11/27 12:59
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysPrivilege {
	/**
	 * 权限ID
	 */
	private Long id;
	/**
	 * 权限名称
	 */
	private String privilegeName;
	/**
	 * 权限URL
	 */
	private String privilegeUrl;
}
