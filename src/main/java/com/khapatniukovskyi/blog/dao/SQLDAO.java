package com.khapatniukovskyi.blog.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.khapatniukovskyi.blog.dao.mapper.MapCategoryMapper;
import com.khapatniukovskyi.blog.entity.Category;

import java.sql.Connection;
import java.util.Map;


public final class SQLDAO {
	private final QueryRunner sql = new QueryRunner();
	
	public Map<Integer, Category> mapCategories(Connection c) throws SQLException {
		return sql.query(c, "select * from category", new MapCategoryMapper());
	}
}
