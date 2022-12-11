package com.gordon.mybatis.type;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author:dongchen
 * @Date: 2022/12/10 16:59
 */
public class EnabledTypeHandler implements TypeHandler<Enabled> {
	@Override
	public void setParameter(PreparedStatement ps, int i, Enabled parameter, JdbcType jdbcType) throws SQLException {

	}

	@Override
	public Enabled getResult(ResultSet rs, String columnName) throws SQLException {
		return null;
	}

	@Override
	public Enabled getResult(ResultSet rs, int columnIndex) throws SQLException {
		return null;
	}

	@Override
	public Enabled getResult(CallableStatement cs, int columnIndex) throws SQLException {
		return null;
	}
}
