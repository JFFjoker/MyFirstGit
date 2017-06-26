package com.market.service;

import java.util.List;
import java.util.Map;

import com.market.dao.BillDao;
import com.market.dao.ProviderDao;
import com.market.dao.UserDao;
import com.market.impl.BillDaoImpl;
import com.market.impl.ProviderDaoImpl;
import com.market.impl.UserDaoImpl;
import com.market.model.BillInfo;
import com.market.model.ProviderInfo;
import com.market.model.UserInfo;

public class ServiceDaoImpl implements ServiceDao{
	UserDao userdao= new UserDaoImpl();
	BillDao billdao = new BillDaoImpl();
	ProviderDao prodao = new ProviderDaoImpl();
	//列表查询
	public List<UserInfo> userlist(){
		return userdao.userlist();
	};
	//匹配查询
	public boolean getUser(UserInfo user){
		return userdao.getUser(user);
	};
	//ͨ获得用户byname
	public UserInfo getOneUserByname(UserInfo user){
		return userdao.getOneUserByname(user);
	}
	//获得用户byid
	public UserInfo getUserByid(UserInfo user){
		return userdao.getUserByid(user);
	}
	//ͨ更新用户byid
	public int updateUserByid(UserInfo user){
		
		return userdao.updateUserByid(user);
			
	};
	//更新密码byid
	public int updatePwd(UserInfo user){
		return userdao.updatePwd(user);
	}
	//删除byid
	public int deleteUserByid(UserInfo user){
		return userdao.deleteUserByid(user);
	}
	//id是否已经存在
	public boolean isExist(UserInfo userinfo){
		return userdao.isExist(userinfo);
	}
	//列表byname
	public List<UserInfo> getUserByname(UserInfo userinfo){
		return userdao.getUserByname(userinfo);
	}
	//增加byid
	public int adduser(UserInfo userinfo){
		return userdao.adduser(userinfo);
	};
	//获得总数
	public int getUserCount(){
		return userdao.getUserCount();
	};
	//分页查询
	public List<UserInfo> getUserBypage(UserInfo userinfo){
		return userdao.getUserBypage(userinfo);
	};	
	//bill-----------------------------------
	//列表查询
		public List<BillInfo> billlist() {
			
			return billdao.billlist();
		}
		//匹配查询
		public boolean getBill(BillInfo bill) {
			return billdao.getBill(bill);
		}
		
		//ͨ获得用户byid
		public BillInfo getBillByid(BillInfo bill) {
			return billdao.getBillByid(bill);
		}
		//增加byid
		public int addBill(BillInfo bill) {
			return billdao.addBill(bill);
		}
		//是否存在byid
		public boolean isExist(BillInfo bill) {
			return billdao.isExist(bill);
		}
		//查询byname
		public List<BillInfo> getBillByname(BillInfo bill) {
			return billdao.getBillByname(bill);
		}
		//serch by condition
		public List<BillInfo> getBillByCon(Map<String,String> map){
			return billdao.getBillByCon(map);
		}
		//serch page 
		public List<BillInfo> getBillPageByCon(BillInfo bill,Map<String,String> map){
			return billdao.getBillPageByCon(bill, map);
		}
		//get providername
		public List<BillInfo> getBillProname(){
			return billdao.getBillProname();
		}
		//分页查询
		public List<BillInfo> getBillBypage(BillInfo bill) {
			return billdao.getBillBypage(bill);
		}
		
		//ͨ更新byid
		public int updateBillByid(BillInfo bill) {
			return billdao.updateBillByid(bill);
		}
		//删除byid
		public int deleteBillByid(BillInfo bill) {
			return billdao.deleteBillByid(bill);
		}
		//获得总数
		public int getBillCount() {
			return billdao.getBillCount();
		}
	//privider---------------------------------------
		//列表查询
		public List<ProviderInfo> prolist() {
			return prodao.prolist();
		}
		//匹配查询
		public boolean getPro(ProviderInfo pro) {
			return prodao.getPro(pro);
		}
		//serch by condition
		public List<ProviderInfo> getProByCon(Map<String,String> map){
			return prodao.getProByCon(map);
		}
		//ͨ获得用户byid
		public ProviderInfo getProByid(ProviderInfo pro) {
			return prodao.getProByid(pro);
		}
		//增加byid
		public int addPro(ProviderInfo pro) {
			return prodao.addPro(pro);
		}
		//是否存在byid
		public boolean isExist(ProviderInfo pro) {
			return prodao.isExist(pro);
		}
		//查询byname
		public List<ProviderInfo> getProByname(ProviderInfo pro) {
			return prodao.getProByname(pro);
		}
		//分页查询
		public List<ProviderInfo> getProBypage(ProviderInfo pro) {
			return prodao.getProBypage(pro);
		}
		//ͨ更新byid
		public int updateProrByid(ProviderInfo pro) {
			return prodao.updateProrByid(pro);
		}
		//删除byid
		public int deleteProByid(ProviderInfo pro) {
			return prodao.deleteProByid(pro);
		}
		//获得总数
		public int getProCount() {
			return prodao.getProCount();
		}
}
