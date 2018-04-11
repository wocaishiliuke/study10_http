package com.study.http.request;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Request6Servlet
 */
@WebServlet("/request6Servlet")
public class Request6Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建画布
		int width = 120;
		int height = 40;
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//获取画笔
		Graphics g = bi.getGraphics();
		//修改背景颜色（填充）
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		//画边框
		g.setColor(Color.RED);
		g.drawRect(0, 0, width-1, height-1);//边框本身占1个像素
		//生成4个随机字符
		Random r = new Random();
		String data = "abcdefghigklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789";
		for (int i = 0; i < 4; i++) {
			g.setFont(new Font("宋体", Font.BOLD, 25));//设置字体
			g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));//随机的RGB颜色
			g.drawString(data.charAt(r.nextInt(data.length())) + "", 10 + i * 30, 25);//将字符均匀的画上
		}
		//画7条干扰线
		for (int i = 0; i < 7; i++) {
			g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));//随机的RGB颜色
			g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
		}
		//输出
		ImageIO.write(bi, "jpg", response.getOutputStream());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
