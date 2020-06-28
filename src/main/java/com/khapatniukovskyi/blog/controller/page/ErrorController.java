package com.khapatniukovskyi.blog.controller.page;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khapatniukovskyi.blog.controller.AbstractController;

@WebServlet("/error")
public class ErrorController extends AbstractController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4921158536740394158L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		forwardToPage("error.jsp", req, resp);
	}
}