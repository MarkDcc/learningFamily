package com.gordon.mybatis.pojo;


import com.gordon.mybatis.type.Enabled;
import lombok.*;

import java.util.Date;

/**
 * @Author:dongchen
 * @Date: 2022/11/27 12:57
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysRole {
	/**
	 * 角色ID
	 */
	private Long id;
	/**
	 * 角色名
	 */
	private String roleName;
	/**
	 * 有效标志
	 */
	private Enabled enabled;
	/**
	 * 创建人
	 */
	private String createBy;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 用户信息
	 */
	//private SysUser user;
}
