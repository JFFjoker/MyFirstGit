package com.market.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.market.dao.BillDao;
import com.market.model.BillInfo;
import com.market.model.ProviderInfo;
import com.market.util.DB;

public class BillDaoImpl extends DB implements BillDao{
	private List<BillInfo> billlist;
	private int count;
	//列表查询
	public List<BillInfo> billlist(){
		billlist = new ArrayList<BillInfo>();
		String sql="select * from BillInfo ";
		
		Object objs[]={};
		res=this.exList(sql, objs);
		try {
			while(res.next()){
				int billid = res.getInt("billid");
				String proname = res.getString("proname");
				int procont = res.getInt("procount");
				float money = res.getInt("promoney");
				String pay = res.getString("propay");
				String providername= res.getString("providername");
				String prodes = res.getString("prodes");
				Date billdate = res.getDate("billdate");
				
				BillInfo bill = new BillInfo(billid,proname,procont,money,pay,providername,prodes,billdate);
				billlist.add(bill);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return billlist;
	};
	//匹配查询
	public boolean getBill(BillInfo bill){
		return false;};
	
	//ͨ获得byid
	public BillInfo getBillByid(BillInfo bill){
		ProviderInfo provider = new ProviderInfo();
		String sql="select * from billinfo  where billid = ?";
		BillInfo billinfo = null;
		Object objs[]={bill.getBillid()};
		res=this.exList(sql, objs);
		try {
			while(res.next()){
				int billid = res.getInt("billid");
				String proname = res.getString("proname");
				int procont = res.getInt("procount");
				float money = res.getInt("promoney");
				String pay = res.getString("propay");
				String providername= res.getString("providername");
				String prodes = res.getString("prodes");
				Date billdate = res.getDate("billdate");
				
				billinfo = new BillInfo(billid,proname,procont,money,pay,providername,prodes,billdate);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return billinfo;
		}
	//增加byid
	public int addBill(BillInfo bill){
		String sql ="INSERT INTO BILLINFO (BILLID, PRONAME, PROCOUNT,"
				+ "PROMONEY, PROPAY, PROVIDERNAME, PRODES, billDATE) VALUES "
				+ " (?,?,?,?,?,?,?,?)";
		Object[] objs={bill.getBillid(),bill.getProname(),bill.getCount(),
				bill.getMoney(),bill.getPay(),bill.getProvidername(),bill.getProdes(),bill.getDate()};
		return this.exupdate(sql, objs);
		}
	//是否存在byid
	public boolean isExist(BillInfo bill){
		return false;
		}
	//查询byname
	public List<BillInfo> getBillByname(BillInfo bill){
		billlist = new ArrayList<BillInfo>();
		String sql="select * from BillInfo where proname=?";
		
		Object objs[]={bill.getProname()};
		res=this.exList(sql, objs);
		try {
			while(res.next()){
				int billid = res.getInt("billid");
				String proname = res.getString("proname");
				int procont = res.getInt("procount");
				float money = res.getInt("promoney");
				String pay = res.getString("propay");
				String providername= res.getString("providername");
				String prodes = res.getString("prodes");
				Date billdate = res.getDate("billdate");
				
				BillInfo billinfo = new BillInfo(billid,proname,procont,money,pay,providername,prodes,billdate);
				billlist.add(billinfo);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return billlist;
		};
	//分页查询
	public List<BillInfo> getBillBypage(BillInfo bill){
		int page= bill.getPage();
 		int rows= bill.getSize();
 		int firstrow = (page-1)*rows;
 		int lastrow = page*rows+1;
 		billlist = new ArrayList<BillInfo>();
		String sql = "select t.* from( select BillInfo.*,rownum rn from BillInfo where rownum<?) t  "
				+ "where t.rn>?";
		Object[] objs={lastrow,firstrow};
		res=this.exList(sql, objs);
		try {
			while(res.next()){
				int billid = res.getInt("billid");
				String proname = res.getString("proname");
				int procont = res.getInt("procount");
				float money = res.getInt("promoney");
				String pay = res.getString("propay");
				String providername= res.getString("providername");
				String prodes = res.getString("prodes");
				Date billdate = res.getDate("billdate");
				
				BillInfo billinfo = new BillInfo(billid,proname,procont,money,pay,providername,prodes,billdate);
				billlist.add(billinfo);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
		return billlist;
		}
	//serch by condition
	public List<BillInfo> getBillByCon(Map<String,String> map){
		billlist =new ArrayList<BillInfo>();
		String proname=" and 1=1 ";//
		String provider=" and 1=1 ";//providername
		String propay=" and 1=1 ";
		System.out.println(map.get("bill")=="");
		if(map.get("bill")==null||(map.get("bill")=="")){
		}else{
			proname=" and proname = '"+map.get("bill")+"' ";
		}
		if(map.get("pro")==null||map.get("pro")==""){
		}else{
			provider =" and providername = '"+map.get("pro")+"' ";
		}
		if(map.get("pay")==null||map.get("pay")==""){
		}else{
			propay ="and propay = '"+map.get("pay")+"' ";
			
		}
		
		getConn();
		
		String sql ="select * from BillInfo where 1=1 "+proname+provider+propay;
		System.out.println(sql);
		try {
			sta=conn.createStatement();
			res=sta.executeQuery(sql);
			while(res.next()){
				int billid = res.getInt("billid");
				String proname2 = res.getString("proname");
				int procont = res.getInt("procount");
				float money = res.getInt("promoney");
				String pay = res.getString("propay");
				String providername= res.getString("providername");
				String prodes = res.getString("prodes");
				Date billdate = res.getDate("billdate");
				
				BillInfo bill = new BillInfo(billid,proname2,procont,money,pay,providername,prodes,billdate);
				billlist.add(bill);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
		
		return billlist;
		
	}
	//serch page by condition
	public List<BillInfo> getBillPageByCon(BillInfo bill,Map<String,String> map){
		billlist =new ArrayList<BillInfo>();
		String proname=" and 1=1 ";//
		String provider=" and 1=1 ";//providername
		String propay=" and 1=1 ";
		System.out.println(map.get("bill")=="");
		if(map.get("bill")==null||(map.get("bill")=="")){
		}else{
			proname=" and proname = '"+map.get("bill")+"' ";
		}
		if(map.get("pro")==null||map.get("pro")==""){
		}else{
			provider =" and providername = '"+map.get("pro")+"' ";
		}
		if(map.get("pay")==null||map.get("pay")==""){
		}else{
			propay ="and propay = '"+map.get("pay")+"' ";
			
		}
		
		getConn();
		int page= bill.getPage();
 		int rows= bill.getSize();
 		int firstrow = (page-1)*rows;
 		int lastrow = page*rows+1;
		/*String sql1="select t.* from( select BillInfo.*,rownum rn from BillInfo where  rownum<?) t  "
				+ "where t.rn>?";*/
		String sql ="select t.* from(  select billinfo.*,rownum rn from BillInfo where 1=1 "+proname+provider+propay+
				" and rownum< "+lastrow+") t  where t.rn> "+firstrow;
		System.out.println(sql);
		try {
			sta=conn.createStatement();
			res=sta.executeQuery(sql);
			while(res.next()){
				int billid = res.getInt("billid");
				String proname2 = res.getString("proname");
				int procont = res.getInt("procount");
				float money = res.getInt("promoney");
				String pay = res.getString("propay");
				String providername= res.getString("providername");
				String prodes = res.getString("prodes");
				Date billdate = res.getDate("billdate");
				
				BillInfo bill2 = new BillInfo(billid,proname2,procont,money,pay,providername,prodes,billdate);
				billlist.add(bill2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
		
		return billlist;
	}
	
	//ͨ更新byid
	public int updateBillByid(BillInfo bill){
		ProviderInfo provider = new ProviderInfo();
		String sql="update  BillInfo set  PRONAME =?,PROCOUNT=?,PROMONEY=?,"
				+ "PROPAY=?,PROVIDERNAME=?,PRODES=? where billid=?";
		
		Object objs[]={bill.getProname(),bill.getCount(),bill.getMoney(),bill.getPay()
				,bill.getProvidername(),bill.getProdes(),bill.getBillid()};
		
		return this.exupdate(sql, objs);
		
		}
	//删除byid
	public int deleteBillByid(BillInfo bill){
		String sql ="delete from BillInfo where billid=?";
		Object[] objs={bill.getBillid()};
		return this.exupdate(sql, objs);
		}
	//获得总数
	public int getBillCount(){
		String sql = "select count(*) count from BillInfo";
		int count= 0;
		Object[] objs={};
			res = this.exList(sql, objs);
			try {
				while(res.next()){
					count = res.getInt("count");
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally {
				closeAll();
			}
		return count;
	}

	//查询优化
	public ResultSet exList(String sql,Object[] objs){
		getConn();
		billlist =new ArrayList<BillInfo>();
		try {
			pres=conn.prepareStatement(sql);
			for(int i=0;i<objs.length;i++){
			pres.setObject(i+1, objs[i]);	
			}
			res=pres.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	//增删改优化
	public int exupdate(String sql,Object[] objs){
		count=0;
		getConn();
		try {
			pres=conn.prepareStatement(sql);
			for(int i=0;i<objs.length;i++){
				pres.setObject(i+1, objs[i]);	
				}
			count=pres.executeUpdate();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return count;
	}
	//get providername
		public List<BillInfo> getBillProname(){
			billlist = new ArrayList();
			
			String sql="SELECT DISTINCT providername names FROM billinfo";
			Object[] objs={};
			res=this.exList(sql, objs);
			try {
				while(res.next()){
					String name = res.getString("names");
					BillInfo bill =new BillInfo();
					bill.setProvidername(name);
					billlist.add(bill);
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally{
				closeAll();
			}
			return billlist;
		}
}
