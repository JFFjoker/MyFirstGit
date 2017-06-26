package com.market.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.market.dao.UserDao;
import com.market.impl.UserDaoImpl;
import com.market.model.UserInfo;
import com.market.service.ServiceDao;
import com.market.service.ServiceDaoImpl;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget");
		super.doGet(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		UserInfo user = new UserInfo(name,pwd);
		ServiceDao serdao= new ServiceDaoImpl();
		boolean flag = serdao.getUser(user);
		
		if(flag){
			
			user = serdao.getOneUserByname(user);
			//System.out.println(user.getAddress()+user.getPassword());
			request.getSession().setAttribute("authuser", user);
			request.getSession().setAttribute("username", name);
			response.sendRedirect("welcome.jsp");
		}else{
			String js="<script type='text/javascript'> alert('登录失败，请重新登录'); </script>";
			request.setAttribute("mess", js);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		System.out.println("logindopost");
	}

}
