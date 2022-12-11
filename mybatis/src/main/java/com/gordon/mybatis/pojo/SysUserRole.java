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
public class SysUserRole {
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 角色ID
	 */
	private Long roleId;

}
