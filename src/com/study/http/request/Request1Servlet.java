package com.study.http.request;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 该servlet用于测试请求行和请求体获取的API
 * @author zhouyu
 * @date 2018年2月19日 下午9:57:09
 */
public class Request1Servlet extends HttpServlet {
	private static final long serialVersionUID = 3908187802385952552L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.获取请求行信息
		//1.1协议类型
		String protocol = req.getProtocol();
		//1.2请求URI
		String uri = req.getRequestURI();
		//1.3请求方法
		String method = req.getMethod();
		//1.4请求的IP
		String ip = req.getRemoteAddr();
		//1.5请求的端口
		int port = req.getLocalPort();
		resp.setContentType("text/html;charset=utf-8");//请求行和头的返回值都是英文，主要是防止代码中的汉字乱码(所以这里用GBK也行)
		
		resp.getWriter().print("请求行信息：<br/>");
		resp.getWriter().print("protocol: " + protocol + "<br/>");
		resp.getWriter().print("uri: " + uri + "<br/>");
		resp.getWriter().print("method: " + method + "<br/>");
		resp.getWriter().print("ip: " + ip + "<br/>");
		resp.getWriter().print("port: " + port + "<br/>");
		resp.getWriter().print("########################<br/>");
		
		//2.获取请求头信息
		//2.1方式一：
		String host = req.getHeader("host");
		String userAgent = req.getHeader("user-agent");
		resp.getWriter().print("请求头信息：<br/>");
		resp.getWriter().print("host: " + host + "<br/>");
		resp.getWriter().print("userAgent: " + userAgent + "<br/>");
		resp.getWriter().print("------------------------<br/>");
		//2.2方式二：
		Enumeration<String> headerNames = req.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			String headerValue = req.getHeader(headerName);
			resp.getWriter().print(headerName + ": " + headerValue + "<br/>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	

}
