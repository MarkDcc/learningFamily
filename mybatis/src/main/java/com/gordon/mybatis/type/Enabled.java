package com.gordon.mybatis.type;

/**
 * @Author:dongchen
 * @Date: 2022/12/10 14:43
 */
public enum Enabled {
	disabled(0),
	enable(1);
	private Integer code;

	Enabled(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
