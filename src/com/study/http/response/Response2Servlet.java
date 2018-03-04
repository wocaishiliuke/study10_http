package com.study.http.response;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Response2Servlet
 */
@WebServlet("/Response2Servlet")
public class Response2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//方式一：页面定时刷新
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print("该商品已下架，5秒后跳转到百度...");
		response.setHeader("refresh", "5;http://www.baidu.com");//5秒后跳转
	}

}
