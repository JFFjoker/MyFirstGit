package com.market.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.market.model.BillInfo;
import com.market.service.ServiceDao;
import com.market.service.ServiceDaoImpl;

public class BillSerchServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("billsearchdoget");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ServiceDao serdao = new ServiceDaoImpl();
		String serchbill =request.getParameter("serchbill");
		//分页部分
		/*BillInfo bill=new BillInfo();
		String spage = request.getParameter("page");
		int page=1;
		if(spage!=null){
			page = Integer.parseInt(spage);
		}
		int size = 5;//每页数据
		int allpage=0;
		if(allpage==0){
			allpage = (serdao.getBillCount()+size-1)/size;
		}
		if(page<1){
			page=1;
		}else if(page>allpage){
			page=allpage;
		}
		bill.setPage(page);
		bill.setSize(size);
		request.setAttribute("pages", allpage);
		request.setAttribute("page", page);*/
		//分页结束
		String serchpro=request.getParameter("serchprovider");
		String pay =request.getParameter("serchpay");
		Map<String,String> map = new HashMap<String, String>();
		map.put("bill", serchbill);
		map.put("pro", serchpro);
		map.put("pay", pay);
		List<BillInfo> billlist= serdao.getBillByCon(map);
		request.setAttribute("billlist", billlist);
		request.getRequestDispatcher("billList.jsp").forward(request, response);
		System.out.println("billsearchdopost");
	}
	

}
