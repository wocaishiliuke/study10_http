package com.study.http.request;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.domain.Product;

/**
 * 该servlet用于测试请求转发
 * @author zhouyu
 * @date 2018年3月4日 下午4:54:27
 */
@WebServlet("/Request4Servlet")
public class Request4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> list = (List<Product>)request.getAttribute("productList");
		response.setContentType("text/html;charset=utf-8");
		for (Product product : list) {
			response.getWriter().println(product + "<br/>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
