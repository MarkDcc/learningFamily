package com.gordon.mybatis.pojo;

import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * @Author:dongchen
 * @Date: 2022/11/27 12:55
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysUser {
	/**
	 * 用户ID
	 */
	private Long id;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String userPassword;
	/**
	 * 邮箱
	 */
	private String userEmail;
	/**
	 * 简介
	 */
	private String userInfo;
	/**
	 * 头像
	 */
	private byte[] headImg;
	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 用户角色
	 */
	private SysRole role;

	/**
	 * 用户的角色集合
	 */
	private List<SysRole> roleList;
}
