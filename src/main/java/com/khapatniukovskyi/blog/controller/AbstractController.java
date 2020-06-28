package com.khapatniukovskyi.blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.khapatniukovskyi.blog.service.BusinessService;
import com.khapatniukovskyi.blog.service.impl.ServiceManager;

public class AbstractController extends HttpServlet {

	/**
	 * Generated Version UID
	 */
	private static final long serialVersionUID = 62504337429437913L;
	protected final Logger LOGGER = LoggerFactory.getLogger(getClass());
	private BusinessService businessService;
	public final BusinessService getBusinessService() {
		return businessService;
	}
	@Override
	public void init() throws ServletException {
		businessService = ServiceManager.getInstance(getServletContext()).getBusinessService();
	}
	/**
	 * I'm trying to use some kind of templating in this snippet
	 * "currentPage" will be parsing and inserting into the page-template.jsp
	 * This way I can dynamically fill the page while maintaining the same status of header and footer
	 */
	public final void forwardToPage (String jspPage, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("currentPage", "page/"+jspPage);
		req.getRequestDispatcher("/WEB-INF/JSP/page-template.jsp").forward(req, resp);
	}
	
	public final void forwardToFragment (String jspPage, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/JSP/fragment/"+jspPage).forward(req, resp);
	}
	
}
