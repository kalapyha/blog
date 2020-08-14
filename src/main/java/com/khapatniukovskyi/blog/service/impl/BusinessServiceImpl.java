package com.khapatniukovskyi.blog.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import com.khapatniukovskyi.blog.dao.SQLDAO;
import com.khapatniukovskyi.blog.entity.Article;
import com.khapatniukovskyi.blog.entity.Category;
import com.khapatniukovskyi.blog.exception.ApplicationException;
import com.khapatniukovskyi.blog.model.Items;
import com.khapatniukovskyi.blog.service.BusinessService;

class BusinessServiceImpl implements BusinessService {
	private final DataSource dataSource;
	private final SQLDAO sql;
	
	BusinessServiceImpl(ServiceManager serviceManager) {
		super();
		this.dataSource = serviceManager.dataSource;
		this.sql = new SQLDAO();
	}

	@Override
	public Map<Integer, Category> mapCategories() {
		try (Connection c = dataSource.getConnection()) {
			return sql.mapCategories(c);
		} catch (SQLException e) {
			throw new ApplicationException("Can't execute db command: " + e.getMessage(), e);
		}
	}
	
	@Override
	public Items<Article> listArticles(int offset, int limit) {
		try (Connection c = dataSource.getConnection()) {
			Items<Article> items = new Items<>();
			items.setItems(sql.listArticles(c, offset, limit));
			items.setCount(sql.countArticles(c));
			return items;
		} catch (SQLException e) {
			throw new ApplicationException("Can't execute db command: " + e.getMessage(), e);
		}
	}
}
