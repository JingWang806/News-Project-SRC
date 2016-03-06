package com.pb.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class myServlet3 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		System.out.println("doGet was used。。。");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("doPost was used");
		super.doPost(req, resp);
	}

	@Override
	public void destroy() {
		System.out.println("destory was used。。。");
		super.destroy();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		String projectName = config.getInitParameter("projectName");
		System.out.println(projectName);
	}
	

}
