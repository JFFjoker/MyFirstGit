package com.market.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hamcrest.core.IsInstanceOf;

import com.market.model.UserInfo;
import com.market.service.ServiceDao;
import com.market.service.ServiceDaoImpl;

public class PwdServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("pwddoget");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ServiceDao serdao = new ServiceDaoImpl();
		String name =  request.getParameter("username");
		PrintWriter out = response.getWriter();
		
		
		String pwd = request.getParameter("newPassword");
		String oldpwd = request.getParameter("oldPassword");
		UserInfo users = new UserInfo();
		users.setUsername(name);
		users.setPassword(oldpwd);
		UserInfo user = serdao.getOneUserByname(users);
		String mess="";
		if(pwd==null||pwd.equals("")){
			mess="不能为空";
		}else if(!pwd.equals(oldpwd)){
			mess="两次密码不同";
		}
		if(pwd.equals(oldpwd)&&serdao.getUser(users)){
			
			user.setPassword(pwd);
			serdao.updatePwd(user);
			request.getSession().setAttribute("authuser", user);
			request.getSession().setAttribute("username", name);
			String js="<script type='text/javascript' charset='utf-8'>"
					+ "alert('修改"+name+"密码成功');	"
					+ "window.location.href='welcome.jsp';</script>";
			out.print(js);
			
			out.close();
		}else{
			String js="<script type='text/javascript' charset='utf-8'>"
					+ "alert('输入有误"+mess+"');	"
					+ "window.location.href='password.jsp';</script>";
			out.print(js);
			
			out.close();
		}
		System.out.println("pwddopost");
	}

}
