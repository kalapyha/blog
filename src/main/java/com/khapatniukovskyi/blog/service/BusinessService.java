package com.khapatniukovskyi.blog.service;

import java.util.Map;

import com.khapatniukovskyi.blog.entity.Article;
import com.khapatniukovskyi.blog.entity.Category;
import com.khapatniukovskyi.blog.exception.RedirectToValidUrlException;
import com.khapatniukovskyi.blog.model.Items;

public interface BusinessService {

	Map<Integer, Category> mapCategories();
	
	Items<Article> listArticles(int offset, int limit);
	
	Items<Article> listArticlesByCategory(String categoryUrl, int offset, int limit);
	
	 Category findCategoryByUrl(String categoryUrl);
	 
	 Items<Article> listArticlesBySearchQuery(String searchQuery, int offset, int limit);
	 
	 Article viewArticle(Long idArticle, String requestUrl) throws RedirectToValidUrlException;
}