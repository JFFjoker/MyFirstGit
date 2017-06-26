package com.market.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.market.dao.UserDao;
import com.market.model.UserInfo;
import com.market.service.ServiceDao;
import com.market.service.ServiceDaoImpl;

public class AdminServlet extends HttpServlet {
	//信息存入用户对象
	public UserInfo intoUser(HttpServletRequest request, HttpServletResponse response){
		
		String ids = request.getParameter("userId");
		int id = Integer.parseInt(ids);
		String username = request.getParameter("username"); 
		String password = request.getParameter("password"); 
		String sextype = request.getParameter("sex");
		String sex=sextype.equals("0")?"男":"女";
		String sage = request.getParameter("age");
		int age = Integer.parseInt(sage);
		String phone = request.getParameter("mobile"); 
		String address = request.getParameter("address"); 
		String type = request.getParameter("auth");
		String auth;
		if (type.equals("0")){
			auth="经理";
		}else{
			auth="员工";
		}
		UserInfo user = new UserInfo(id,username,password,sex,age,phone,address,auth);
		return user;
	};
	//
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ServiceDao serdao = new ServiceDaoImpl();
		//String sertype = request.getParameter("sertype");
		//System.out.println(sertype);
		/*if(sertype!=null&&sertype.equals("1")){
			
		}else{*/
			UserInfo user=new UserInfo();
			
			String spage = request.getParameter("page");
			int page=1;
			if(spage!=null){
				page = Integer.parseInt(spage);
			}
			int size = 5;//每页数据
			int allpage=0;
			if(allpage==0){
				allpage = (serdao.getUserCount()+size-1)/size;
			}
			if(page<1){
				page=1;
			}else if(page>allpage){
				page=allpage;
			}
			user.setPage(page);
			user.setSize(size);
			
			//Object obj = request.getSession().getAttribute("authuser");
			//System.out.println(obj ==null);
			request.setAttribute("pages", allpage);
			List<UserInfo> userlist= serdao.getUserBypage(user);
			request.setAttribute("userlist", userlist);
			request.setAttribute("page", page);
		//}
		request.getRequestDispatcher("userList.jsp").forward(request, response);
	
		System.out.println("admindoget");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ServiceDao serdao = new ServiceDaoImpl();
		String serchname = request.getParameter("serchname");
		UserInfo user= new UserInfo();
		user.setUsername(serchname);
		System.out.println("serch"+serchname);
		List<UserInfo> userlist=serdao.userlist();
		if(serchname==null||serchname.equals("")){
			
		}else{
			
			userlist= serdao.getUserByname(user);
		}
		String sertype = request.getParameter("sertype");
		System.out.println(sertype);
		request.setAttribute("userlist", userlist);
		request.getRequestDispatcher("userList.jsp").forward(request, response);
	
	}
	

}
