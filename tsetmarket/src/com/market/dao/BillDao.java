package com.market.dao;

import java.util.List;
import java.util.Map;

import com.market.model.BillInfo;

public interface BillDao {
	//列表查询
	public List<BillInfo> billlist();
	//匹配查询
	public boolean getBill(BillInfo bill);
	
	//ͨ获得用户byid
	public BillInfo getBillByid(BillInfo bill);
	//增加byid
	public int addBill(BillInfo bill);
	//是否存在byid
	public boolean isExist(BillInfo bill);
	//查询byname
	public List<BillInfo> getBillByname(BillInfo bill);
	//分页查询
	public List<BillInfo> getBillBypage(BillInfo bill);
	//serch by condition
	public List<BillInfo> getBillByCon(Map<String,String> map);
	//ͨ更新byid
	public int updateBillByid(BillInfo bill);
	//删除byid
	public int deleteBillByid(BillInfo bill);
	//获得总数
	public int getBillCount();
	//serch page 
	public List<BillInfo> getBillPageByCon(BillInfo bill,Map<String,String> map);
	//get providername
	public List<BillInfo> getBillProname();
}
