package com.market.service;

import java.util.List;
import java.util.Map;

import com.market.dao.UserDao;
import com.market.impl.UserDaoImpl;
import com.market.model.BillInfo;
import com.market.model.ProviderInfo;
import com.market.model.UserInfo;

public interface ServiceDao {
	//userinfo部分
	//列表查询
	public List<UserInfo> userlist();
	//匹配查询
	public boolean getUser(UserInfo user);
	//ͨ获得用户byid
	public UserInfo getUserByid(UserInfo user);
	
	//ͨ获得用户byname
	public UserInfo getOneUserByname(UserInfo user);
	//删除byid
	public int deleteUserByid(UserInfo user);
	//更新byid
	public int updateUserByid(UserInfo user);
	//更新密码byid
	public int updatePwd(UserInfo user);
	//查询byname
	public int adduser(UserInfo userinfo);
	//ͨ匹配
	public boolean isExist(UserInfo userinfo);
	//userbyid
	public List<UserInfo> getUserByname(UserInfo userinfo);
	//获得总数
	public int getUserCount();
	//分页查询
	public List<UserInfo> getUserBypage(UserInfo userinfo);
	
	
	//----------------------------bill
	//bill部分
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
	//get providername
	public List<BillInfo> getBillProname();
	//ͨ更新byid
	public int updateBillByid(BillInfo bill);
	//删除byid
	public int deleteBillByid(BillInfo bill);
	//获得总数
	public int getBillCount();
	//serch page 
	public List<BillInfo> getBillPageByCon(BillInfo bill,Map<String,String> map);
	//provider部分-------------------------
		//列表查询
	public List<ProviderInfo> prolist();
	//匹配查询
	public boolean getPro(ProviderInfo pro);
	
	//ͨ获得用户byid
	public ProviderInfo getProByid(ProviderInfo pro);
	//增加byid
	public int addPro(ProviderInfo pro);
	//是否存在byid
	public boolean isExist(ProviderInfo userinfo);
	//查询byname
	public List<ProviderInfo> getProByname(ProviderInfo pro);
	//serch by condition
	public List<ProviderInfo> getProByCon(Map<String,String> map);
	//分页查询
	public List<ProviderInfo> getProBypage(ProviderInfo pro);
	//ͨ更新byid
	public int updateProrByid(ProviderInfo pro);
	//删除byid
	public int deleteProByid(ProviderInfo pro);
	//获得总数
	public int getProCount();
	
}
