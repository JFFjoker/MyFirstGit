package com.market.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.market.model.BillInfo;
import com.market.service.ServiceDao;
import com.market.service.ServiceDaoImpl;

public class BillInfoServlet extends HttpServlet{
	//存入用户对象
	public BillInfo intoBill(HttpServletRequest request, HttpServletResponse response){
		
		String ids = request.getParameter("billid");
		int id = Integer.parseInt(ids);
		String proname = request.getParameter("proname"); 
		String scount = request.getParameter("count");
		int count = Integer.parseInt(scount);
		
		String smoney = request.getParameter("money");
		float money = Float.parseFloat(smoney);
		String pay = request.getParameter("pay");
		//System.out.println(count);
		String providername = request.getParameter("providername"); 
		String prodes = request.getParameter("prodes");
		
		BillInfo bill = new BillInfo(id,proname,count,money,pay,providername,prodes);
		return bill;
	};
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		ServiceDao serdao = new ServiceDaoImpl();
		PrintWriter out = response.getWriter();
		String billids = request.getParameter("billid");
		int billid = Integer.parseInt(billids);
		String stype=request.getParameter("type");//0详细1修改2删除
		System.out.println(stype);
		int type=0;
		if(stype!=null){
			type=Integer.parseInt(stype);
		}
		BillInfo bill = new BillInfo();
		bill.setBillid(billid);
		bill = serdao.getBillByid(bill);
		request.getSession().setAttribute("bill", bill);
		
		System.out.println(bill);
		if(type==0){
			response.sendRedirect("billView.jsp");
		}else if(type==1){
			//byid更新
			
			response.sendRedirect("billUpdate.jsp");
		}else if(type==2){
			//byid删除
			serdao.deleteBillByid(bill);
			String js="<script type='text/javascript' charset='utf-8'>"
					+ "alert('删除"+bill.getBillid()+"号订单成功');	"
					+ "window.location.href='billServlet';</script>";
			out.print(js);
			
			out.close();
		}
	
		System.out.println("billinfodoget");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ServiceDao serdao = new ServiceDaoImpl();
		PrintWriter out = response.getWriter();
		String billids = request.getParameter("billid");
		int billid = Integer.parseInt(billids);
		String stype=request.getParameter("type");//1修改3新增
		int type=0;
		if(stype!=null){
			type=Integer.parseInt(stype);
		}
		if(type==3){
			BillInfo bill = this.intoBill(request, response);
			java.util.Date a = new java.util.Date();
			java.sql.Date date = new java.sql.Date(a.getTime());
			bill.setDate(date);
			serdao.addBill(bill);
			String js="<script type='text/javascript' charset='utf-8'>"
					+ "alert('增加"+bill.getBillid()+"号订单成功');	"
					+ "window.location.href='billServlet';</script>";
			out.print(js);
			
			out.close();
			
		}else if(type==1){
			BillInfo bill = this.intoBill(request, response);
			serdao.updateBillByid(bill);
			String js="<script type='text/javascript' charset='utf-8'>"
					+ "alert('更新"+bill.getBillid()+"号订单成功');	"
					+ "window.location.href='billServlet';</script>";
			out.print(js);
			
			out.close();
		}
		
		System.out.println(billids+"+"+type);
		System.out.println("billinfodopost");
	}

}
