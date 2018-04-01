package com.study.http.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/request5Servlet")
public class Request5Servlet extends HttpServlet {
	private static final long serialVersionUID = 5092348049868748127L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String referer = req.getHeader("referer");
		resp.setContentType("text/html;charset=utf-8");
		if (referer != null && referer.startsWith("http://localhost:8080/study10_http")) {
			resp.getWriter().println("随便下载，注意身体！");
		}else {
			resp.getWriter().println("WARNING：请从官网下载！");
		}
	}
	
}
