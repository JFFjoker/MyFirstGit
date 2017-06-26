package com.market.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.market.model.ProviderInfo;
import com.market.service.ServiceDao;
import com.market.service.ServiceDaoImpl;

public class ProServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ServiceDao serdao = new ServiceDaoImpl();
		ProviderInfo pro=new ProviderInfo();
		
		String spage = request.getParameter("page");
		int page=1;
		if(spage!=null){
			page = Integer.parseInt(spage);
		}
		int size = 5;//每页数据
		int allpage=0;
		if(allpage==0){
			allpage = (serdao.getProCount()+size-1)/size;
		}
		if(page<1){
			page=1;
		}else if(page>allpage){
			page=allpage;
		}
		pro.setPage(page);
		pro.setSize(size);
		
		
		request.setAttribute("pages", allpage);
		List<ProviderInfo> prolist= serdao.getProBypage(pro);
		request.setAttribute("prolist", prolist);
		request.setAttribute("page", page);
	//}
	request.getRequestDispatcher("providerList.jsp").forward(request, response);
		System.out.println("prodoget");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("prodopost");
	}

}
