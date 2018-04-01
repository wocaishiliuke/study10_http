package com.study.http.response;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用于测试重定向
 * @author zhouyu
 * @date 2018年3月4日 下午6:27:38
 */
@WebServlet("/Response1Servlet")
public class Response1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置重定向状态码
		//response.setStatus(302);
		//设置location头信息
		//response.setHeader("location", "http://localhost:8080/study09_tomcat-servlet/welcome.html");
		response.sendRedirect("http://localhost:8080/study09_tomcat-servlet/welcome.html");
		return;
	}


}
