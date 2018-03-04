package com.study.http.request;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 该servlet用于测试请求参数的获取和乱码处理
 * 这里的乱码指请求参数传递到代码中时的乱码
 * Tomcat8及以后的版本，请改成默认编码为ISO-8859-1再测试...
 * @author zhouyu
 * @date 2018年2月19日 下午10:05:27
 */
@WebServlet(name="request2Servlet", urlPatterns="/request2")
public class Request2Servlet extends HttpServlet {

	//通过get.html提交访问该方法
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.参数获取(GET和POST获取参数的方式一样，只是传递参数方式不同，所以dopost中不再重复这部分代码)
		//1.1 方式一
		String username = req.getParameter("username");
		String sex = req.getParameter("sex");
		String[] hobbies = req.getParameterValues("hobby");
		System.out.println(username);
		System.out.println(sex);
		System.out.println(Arrays.toString(hobbies));
		System.out.println("-------------------------");
		//1.2 方式二
		Enumeration<String> parameterNames = req.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String param = parameterNames.nextElement();
			String[] values = req.getParameterValues(param);
			System.out.println(param + ": " + Arrays.toString(values));
		}
		System.out.println("-------------------------");
		//1.3 方式三：Tomcat会将参数的名和值，以map的形式封装到request中
		Map<String, String[]> parameterMap = req.getParameterMap();
		Set<String> keySet = parameterMap.keySet();
		for (String key : keySet) {
			//String[] values = req.getParameterValues(key);
			String[] values = parameterMap.get(key);
			System.out.println(key + ": " + Arrays.toString(values));
		}
		System.out.println("#########################");
		
		
		//2.乱码解决(Tomcat7及以前版本的默认编码集，默认才是ISO-8859-1)
		//2.1 方式一：修改Tomcat配置
		//2.2 方式二：先编码再解码
		//2.2.1
		String encodeString = URLEncoder.encode(username,"ISO-8859-1");
		String firstUsername = URLDecoder.decode(encodeString,"UTF-8");
		System.out.println("first:" + firstUsername);
		//2.2.2 更优雅
		//byte[] encodeBytes = username.getBytes("ISO-8859-1");
		//String secondUsername = new String(encodeBytes, "UTF-8");
		String secondUsername = new String(username.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("second:" + secondUsername);
		
	}

	//通过post.html提交访问该方法
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.参数获取(GET和POST获取参数的方式一样，只是传递参数方式不同，所以dopost中不再重复这部分代码)
		
		//2.乱码解决(Tomcat7及以前版本的默认编码集，默认才是ISO-8859-1)
		/*前两种同GET
		//2.1 方式一：修改Tomcat配置
		//2.2 方式二：先编码再解码
		//2.2.1
		String username = req.getParameter("username");
		System.out.println(username);
		String encodeString = URLEncoder.encode(username,"ISO-8859-1");
		String firstUsername = URLDecoder.decode(encodeString,"UTF-8");
		System.out.println("first:" + firstUsername);
		//2.2.2 更优雅
		//byte[] encodeBytes = username.getBytes("ISO-8859-1");
		//String secondUsername = new String(encodeBytes, "UTF-8");
		String secondUsername = new String(username.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("second:" + secondUsername);
		*/
		//2.3 方式三：设置请求体编码(POST有请求体，GET没有；对请求体的多个参数都有用哦)，更优雅
		req.setCharacterEncoding("UTF-8");//底层做了先编码后解码，只对请求体有效
		String thirdUsername = req.getParameter("username");
		System.out.println("third:" + thirdUsername);
	}	
}
