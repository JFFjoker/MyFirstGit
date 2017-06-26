package com.market.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.market.dao.BillDao;
import com.market.impl.BillDaoImpl;
import com.market.model.BillInfo;
import com.market.model.ProviderInfo;
import com.market.service.ServiceDao;
import com.market.service.ServiceDaoImpl;

public class testforserch {

	public static void main(String[] args) {
		ServiceDao serdao = new ServiceDaoImpl();
		//测试bill
		BillInfo bill = new BillInfo();
		bill.setPage(1);
		bill.setSize(5);
		Map<String,String> map = new HashMap<String, String>();
		map.put("bill", null);
		map.put("pro", null);
		map.put("pay", null);
//		List<BillInfo> billlist = serdao.getBillByCon(map);
		List<BillInfo> billlist = serdao.getBillPageByCon(bill, map);
		for (BillInfo bill2 : billlist) {
			System.out.println(bill2.getProname());
		}
		//测试pro
		/*Map<String,String> map2 = new HashMap<String, String>();
		map2.put("proname",null);
		map2.put("des", "芬");
		
		List<ProviderInfo> prolist = serdao.getProByCon(map2);
		for (ProviderInfo pro : prolist) {
			System.out.println(pro.getProman());
		}*/
		System.out.println("============");
		BillDao billdao = new BillDaoImpl();
		//List<String> namelist = new ArrayList();
		billlist = billdao.getBillProname();
		for (BillInfo bill2 : billlist) {
			System.out.println(bill2.getProvidername());
		}
	}

}
