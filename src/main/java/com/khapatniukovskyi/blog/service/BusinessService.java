package com.khapatniukovskyi.blog.service;

import java.util.Map;

import com.khapatniukovskyi.blog.entity.Category;

public interface BusinessService {
	Map<Integer, Category> mapCategories();
}