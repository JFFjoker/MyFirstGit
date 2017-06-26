package com.market.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.market.dao.BillDao;
import com.market.dao.ProviderDao;
import com.market.dao.UserDao;
import com.market.impl.BillDaoImpl;
import com.market.impl.ProviderDaoImpl;
import com.market.impl.UserDaoImpl;
import com.market.model.BillInfo;
import com.market.model.ProviderInfo;
import com.market.model.UserInfo;
import com.market.service.ServiceDao;
import com.market.service.ServiceDaoImpl;

import sun.java2d.pipe.SpanShapeRenderer.Simple;

public class DBtest {

	public static void main(String[] args) {
		
		/*UserDao userdao = new UserDaoImpl();
		 java.util.Date a = new java.util.Date();
         System.out.println(a);
         java.sql.Date b = new java.sql.Date(a.getTime());
         System.out.println(b);
		UserInfo user;
			user = new UserInfo(1004,"username","password",
					"sex",20,"phone","address","auth");
			
			
		System.out.println(userdao.getUserCount());
		System.out.println(userdao.isExist(user));*/
		/*UserDao userdao = new UserDaoImpl();
		UserInfo user=new UserInfo();
		user.setPage(1);
		user.setSize(5);
		List<UserInfo> list=userdao.getUserBypage(user);
		for (UserInfo userInfo : list) {
			System.out.println(userInfo.getUsername());
//		}*/
		ProviderDao prodao = new ProviderDaoImpl();
		java.util.Date a = new java.util.Date();
        java.sql.Date b = new java.sql.Date(a.getTime());
        System.out.println(b);
        /*ProviderInfo pro =new ProviderInfo(3,"芬达公司","芬达人","789",
				"789","提供芬达","芬达星",b	);
		ProviderInfo pro2 =new ProviderInfo(4,"芬达公司","芬达人","789",
				"789","提供芬达","芬达星",pro.getProdate());*/
		/*pro.setProviderid(1);
		pro.setPage(1);
		pro.setSize(2);
		pro.setProvidername("可乐公司");*/
		
		//prodao.updateProrByid(pro2);
		//prodao.addPro(pro2);
		/*prodao.deleteProByid(pro2);
		List<ProviderInfo> prolist=prodao.prolist();
		//List<ProviderInfo> prolist=prodao.getProBypage(pro);
		for (ProviderInfo pros : prolist) {
			System.out.println(pros.getProvidername());
		}*/
		//System.out.println(prodao.getProByname(pro).get(0).getProdate());
		//System.out.println(prodao.getProCount());
		//for billinfo
		BillDao billdao = new BillDaoImpl();
		BillInfo billinfo = new BillInfo(4,"b",30,30,"是","s","s",b);
		//billinfo.setProname("可乐");
		//billdao.addBill(billinfo);
		BillInfo bill2 = new BillInfo();
		bill2.setPage(1);
		bill2.setSize(2);
		//List<BillInfo> billlist=billdao.getBillByname(billinfo);
		//List<BillInfo> billlist=billdao.billlist();
		List<BillInfo> billlist=billdao.getBillBypage(bill2);
		for (BillInfo bill : billlist) {
			System.out.println(bill.getProname());
		}
		BillInfo bill = new BillInfo();
		bill.setBillid(4);
		//billdao.deleteBillByid(bill);
		billdao.updateBillByid(billinfo);
		System.out.println(billdao.getBillByid(bill).getProname());
		//System.out.println(billdao.getBillCount());
		ProviderInfo pro =new ProviderInfo(3,"芬达公司","芬达人","789",
				"789","提供芬达","芬达星",b	);
		pro.setPage(1);
		pro.setSize(2);
		List<ProviderInfo> prolist=prodao.getProBypage(pro);
		for (ProviderInfo pros : prolist) {
			System.out.println(pros.getProvidername());
		}
	}

}
