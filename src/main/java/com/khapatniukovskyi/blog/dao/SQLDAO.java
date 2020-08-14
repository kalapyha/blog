package com.khapatniukovskyi.blog.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.khapatniukovskyi.blog.dao.mapper.ArticleMapper;
import com.khapatniukovskyi.blog.dao.mapper.ListMapper;
import com.khapatniukovskyi.blog.dao.mapper.MapCategoryMapper;
import com.khapatniukovskyi.blog.entity.Article;
import com.khapatniukovskyi.blog.entity.Category;



public final class SQLDAO {
	private final QueryRunner sql = new QueryRunner();
	
	public Map<Integer, Category> mapCategories(Connection c) throws SQLException {
		return sql.query(c, "select * from category", new MapCategoryMapper());
	}
	
	public List<Article> listArticles(Connection c, int offset, int limit) throws SQLException {
		return sql.query(c, "select * from article a order by a.id desc limit ? offset ?", new ListMapper<>(new ArticleMapper()), limit, offset);
	}
	
	public int countArticles(Connection c) throws SQLException {
		return sql.query(c, "select count(*) from article a", new ScalarHandler<Number>()).intValue();
	}
}