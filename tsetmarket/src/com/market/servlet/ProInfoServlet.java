package com.market.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.market.model.ProviderInfo;
import com.market.service.ServiceDao;
import com.market.service.ServiceDaoImpl;

public class ProInfoServlet extends HttpServlet{
	//存入用户对象
	public ProviderInfo intoPro(HttpServletRequest request, HttpServletResponse response){
		String ids = request.getParameter("proid");
		int id = Integer.parseInt(ids);
		String proname = request.getParameter("proname"); 
		
		String proman = request.getParameter("proman");
		String mobile = request.getParameter("mobile");
		String fax = request.getParameter("fax");
		String des = request.getParameter("des");
		String address = request.getParameter("address");
		
		ProviderInfo pro = new ProviderInfo(id,proname,proman,mobile,fax,des,address);
		return pro;
	};
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		ServiceDao serdao = new ServiceDaoImpl();
		PrintWriter out = response.getWriter();
		String proids = request.getParameter("proid");
		int proid = Integer.parseInt(proids);
		String stype=request.getParameter("type");//0详细1修改2删除
		int type=0;
		if(stype!=null){
			type=Integer.parseInt(stype);
		}
		ProviderInfo pro = new ProviderInfo();
		pro.setProviderid(proid);
		pro = serdao.getProByid(pro);
		request.getSession().setAttribute("pro", pro);
		
		System.out.println(pro);
		if(type==0){
			response.sendRedirect("providerView.jsp");
		}else if(type==1){
			//byid更新
			
			response.sendRedirect("providerUpdate.jsp");
		}else if(type==2){
			//byid删除
			serdao.deleteProByid(pro);
			String js="<script type='text/javascript' charset='utf-8'>"
					+ "alert('删除"+pro.getProviderid()+"号供应商成功');	"
					+ "window.location.href='proServlet';</script>";
			out.print(js);
			
			out.close();
		}
	
		System.out.println("proinfodoget");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ServiceDao serdao = new ServiceDaoImpl();
		String proids = request.getParameter("proid");
		int proid = Integer.parseInt(proids);
		String stype=request.getParameter("type");//1修改3新增
		int type=0;
		if(stype!=null){
			type=Integer.parseInt(stype);
		}
		if(type==3){
			ProviderInfo pro = this.intoPro(request, response);
			java.util.Date a = new java.util.Date();
			java.sql.Date date = new java.sql.Date(a.getTime());
			pro.setProdate(date);
			serdao.addPro(pro);
			String js="<script type='text/javascript' charset='utf-8'>"
					+ "alert('增加"+pro.getProviderid()+"号供应商成功');	"
					+ "window.location.href='proServlet';</script>";
			out.print(js);
			
			out.close();
			
		}else if(type==1){
			ProviderInfo pro = this.intoPro(request, response);
			serdao.updateProrByid(pro);
			String js="<script type='text/javascript' charset='utf-8'>"
					+ "alert('更新"+pro.getProviderid()+"号供应商成功');	"
					+ "window.location.href='proServlet';</script>";
			out.print(js);
			
			out.close();
		}
		
		System.out.println(proids+"+"+type);
		System.out.println("proinfodopost");
	}

}
