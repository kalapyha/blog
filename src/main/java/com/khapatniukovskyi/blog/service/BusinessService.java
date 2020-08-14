package com.khapatniukovskyi.blog.service;

import java.util.Map;

import com.khapatniukovskyi.blog.entity.Article;
import com.khapatniukovskyi.blog.entity.Category;
import com.khapatniukovskyi.blog.model.Items;

public interface BusinessService {

	Map<Integer, Category> mapCategories();
	
	Items<Article> listArticles(int offset, int limit);
}