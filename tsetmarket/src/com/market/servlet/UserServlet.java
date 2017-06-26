package com.market.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.market.model.UserInfo;
import com.market.service.ServiceDao;
import com.market.service.ServiceDaoImpl;

public class UserServlet extends HttpServlet {
	//存入用户对象
	public UserInfo intoUser(HttpServletRequest request, HttpServletResponse response){
		String ids = request.getParameter("userid");
		int id = Integer.parseInt(ids);
		String username = request.getParameter("username"); 
		
		String sex = request.getParameter("sex");
		String sage = request.getParameter("age");
		int age = Integer.parseInt(sage);
		
		System.out.println(sex);
		String phone = request.getParameter("mobile"); 
		String address = request.getParameter("userAddress"); 
		String auth = request.getParameter("auth");
		UserInfo user = new UserInfo(id,username,sex,age,phone,address,auth);
		return user;
	};
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		ServiceDao serdao = new ServiceDaoImpl();
		PrintWriter out = response.getWriter();
		String userids = request.getParameter("userid");
		int userid = Integer.parseInt(userids);
		String stype=request.getParameter("type");//0详细1修改2删除
		int type=0;
		if(stype!=null){
			type=Integer.parseInt(stype);
		}
		UserInfo user = new UserInfo();
		user.setUserid(userid);
		user = serdao.getUserByid(user);
		request.getSession().setAttribute("user", user);
		
		System.out.println(user);
		if(type==0){
			response.sendRedirect("userView.jsp");
		}else if(type==1){
			//byid更新
			
			response.sendRedirect("userUpdate.jsp");
		}else if(type==2){
			//byid删除
			serdao.deleteUserByid(user);
			String js="<script type='text/javascript' charset='utf-8'>"
					+ "alert('删除成功');	"
					+ "window.location.href='adminServlet';</script>";
			out.print(js);
			
			out.close();
		}
	
		System.out.println("userdoget");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset-utf-8");
		ServiceDao serdao = new ServiceDaoImpl();
		String userids = request.getParameter("userid");
		int userid = Integer.parseInt(userids);
		String stype=request.getParameter("type");//1修改3新增
		int type=0;
		if(stype!=null){
			type=Integer.parseInt(stype);
		}
		if(type==3){
			UserInfo user = this.intoUser(request, response);
			serdao.adduser(user);
			response.sendRedirect("adminServlet");
		}else if(type==1){
			UserInfo user = this.intoUser(request, response);
			serdao.updateUserByid(user);
			response.sendRedirect("adminServlet");
		}
		
		System.out.println(userids+"+"+type);
		System.out.println("userdopost");
	}
	
}
