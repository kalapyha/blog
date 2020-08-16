package com.khapatniukovskyi.blog.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "ErrorHandlerFilter", urlPatterns = "/*")
public class ErrorHandlerFilter extends AbstractFilter {

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
		try {
			chain.doFilter(req, resp);
		} catch (Throwable th) {
			String requestUrl = req.getRequestURI();
			LOGGER.error("Error during processing the request: " + requestUrl, th);
			if (requestUrl.startsWith("/ajax/")) {
				resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			} else if (!requestUrl.startsWith("/error")) {
				// Message to user |  ErrorController
				resp.sendRedirect("error.jsp");
			} else {
				// Escape from cycle redirect here 
				throw new ServletException(th);
			}
		}
	}
}
