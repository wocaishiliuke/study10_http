package com.study.http;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.domain.Product;

/**
 * 该servlet用于测试请求转发
 * 一般经request3Servlet查询出商品，转发给request4Servlet（JSP）来渲染
 * @author zhouyu
 * @date 2018年3月4日 下午4:53:53
 */
@WebServlet(name="request3Servlet", urlPatterns="/request3Servlet")
public class Request3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> list = new ArrayList<>();
		list.add(new Product(1L,"华晨宝马",new BigDecimal(500000)));
		list.add(new Product(2L,"奔驰GLK",new BigDecimal(450000)));
		list.add(new Product(3L,"五菱宏光",new BigDecimal(1000000)));
		request.setAttribute("productList", list);
		//项目服务器端："/"表示http://ip:port/项目名
		request.getRequestDispatcher("/Request4Servlet").forward(request, response);;
		return;//请求转发后一般都要return,交由其他资源处理，该方法要结束；在方法最后也可省略
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
