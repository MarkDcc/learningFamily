package com.gordon.mybatis.pojo;

import lombok.*;

/**
 * @Author:dongchen
 * @Date: 2022/11/27 13:00
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysRolePrivilege {
	/**
	 * 角色ID
	 */
	private Long roleId;
	/**
	 * 权限ID
	 */
	private Long privilegeId;
}
