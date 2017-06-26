package com.market.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.market.model.ProviderInfo;
import com.market.service.ServiceDao;
import com.market.service.ServiceDaoImpl;

public class ProSerchServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		System.out.println("billsearchdoget");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ServiceDao serdao = new ServiceDaoImpl();
		String proname =request.getParameter("serchproname");
		String des=request.getParameter("serchdes");
		System.out.println(proname+des+"----");
		
		Map<String,String> map = new HashMap<String, String>();
		map.put("proname", proname);
		map.put("des", des);
		List<ProviderInfo> prolist= serdao.getProByCon(map);
		request.setAttribute("prolist", prolist);
		request.getRequestDispatcher("providerList.jsp").forward(request, response);
		System.out.println("billsearchdopost");
	}
}
