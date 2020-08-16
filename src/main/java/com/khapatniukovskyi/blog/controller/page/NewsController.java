package com.khapatniukovskyi.blog.controller.page;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khapatniukovskyi.blog.Constants;
import com.khapatniukovskyi.blog.controller.AbstractController;
import com.khapatniukovskyi.blog.entity.Article;
import com.khapatniukovskyi.blog.entity.Category;
import com.khapatniukovskyi.blog.model.Items;

@WebServlet({"/news", "/news/*"})
public class NewsController extends AbstractController {
	private static final long serialVersionUID = 216595477139640552L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestUrl = req.getRequestURI();
		Items<Article> items = null;
		if(requestUrl.endsWith("/news") || requestUrl.endsWith("/news/")){
			items = getBusinessService().listArticles(0, Constants.LIMIT_ARTICLES_PER_PAGE);
		}
		else{
			String categoryUrl = requestUrl.replace("http://localhost:8080/ROOT/news", "");
			System.out.println(categoryUrl);
			items = getBusinessService().listArticlesByCategory(categoryUrl, 0, Constants.LIMIT_ARTICLES_PER_PAGE);
			Category category = getBusinessService().findCategoryByUrl(categoryUrl);
			req.setAttribute("selectedCategory", category);
		}
		req.setAttribute("list", items.getItems());
		forwardToPage("news.jsp", req, resp);
	}
}
