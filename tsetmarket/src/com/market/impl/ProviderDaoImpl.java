package com.market.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.market.dao.ProviderDao;
import com.market.model.BillInfo;
import com.market.model.ProviderInfo;
import com.market.model.UserInfo;
import com.market.util.DB;

public class ProviderDaoImpl extends DB implements ProviderDao {
	private List<ProviderInfo> providerlist;
	private int count;
	//列表查询
	public List<ProviderInfo> prolist() {
		providerlist = new ArrayList<ProviderInfo>();
		String sql="select * from providerinfo ";
		
		Object objs[]={};
		res=this.exList(sql, objs);
		try {
			while(res.next()){
				int providerid = res.getInt("proid");
				String providername = res.getString("proname");
				String proman = res.getString("proman");
				String mobile = res.getString("mobile");
				String fax = res.getString("fax");
				String des= res.getString("des");
				String address = res.getString("address");
				Date prodate = res.getDate("prodate");
				
				ProviderInfo provider = new ProviderInfo(providerid,providername,des,proman,mobile,fax,address,prodate);
				providerlist.add(provider);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return providerlist;
	}
	//匹配查询
	public boolean getPro(ProviderInfo pro) {
		return false;
	}
	//serch by condition
	public List<ProviderInfo> getProByCon(Map<String,String> map){
		
		providerlist =new ArrayList<ProviderInfo>();
		
		String proname=" and 1=1";//providername
		String dess=" and 1=1";
		if(map.get("proname")==null||map.get("proname")==""){
		}else{
			proname=" and proname = '"+map.get("proname")+"'";
		}
		
		if(map.get("des")==null||map.get("des")==""){
		}else{
			dess ="and des like '%"+map.get("des")+"%'";
		}
		
		getConn();
		String sql ="select * from ProviderInfo where 1=1 "+proname+dess;
		
		System.out.println(sql);
		try {
			sta=conn.createStatement();
			res=sta.executeQuery(sql);
			while(res.next()){
				int providerid = res.getInt("proid");
				String providername = res.getString("proname");
				String proman = res.getString("proman");
				String mobile = res.getString("mobile");
				String fax = res.getString("fax");
				String des= res.getString("des");
				String address = res.getString("address");
				Date prodate = res.getDate("prodate");
				
				ProviderInfo provider = new ProviderInfo(providerid,providername,des,proman,mobile,fax,address,prodate);
				providerlist.add(provider);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
		
		return providerlist;
	}
	//ͨ获得probyid
	public ProviderInfo getProByid(ProviderInfo pro) {
		ProviderInfo provider = new ProviderInfo();
		String sql="select * from providerinfo  where proid = ?";
		
		Object objs[]={pro.getProviderid()};
		res=this.exList(sql, objs);
		try {
			while(res.next()){
				int providerid = res.getInt("proid");
				String providername = res.getString("proname");
				String proman = res.getString("proman");
				String mobile = res.getString("mobile");
				String fax = res.getString("fax");
				String des= res.getString("des");
				String address = res.getString("address");
				Date prodate = res.getDate("prodate");
				
				provider = new ProviderInfo(providerid,providername,des,proman,mobile,fax,address,prodate);
				providerlist.add(provider);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return provider;
		
	}
	//增加byid
	public int addPro(ProviderInfo pro) {
		String sql = "insert into ProviderInfo (proid,proname,proman,mobile,fax,des,address,prodate) values(?,?,?,?,?,?,?,?)";
		Object[] objs = {pro.getProviderid(),pro.getProvidername(),pro.getProman(),pro.getMobile(),pro.getFax(),pro.getDes(),pro.getAddress(),pro.getProdate()};
		count = this.exupdate(sql, objs);
		return count;
		
	}
	//是否存在byid
	public boolean isExist(ProviderInfo pro) {
		boolean flag = false;
		String sql="select * from providerinfo where proid=?";
		Object[] objs ={pro.getProviderid()};
		res=this.exList(sql, objs);
		try {
			while(res.next()){
				flag=true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return flag;
		
	}
	//查询byname
	public List<ProviderInfo> getProByname(ProviderInfo pro) {
		providerlist = new ArrayList<ProviderInfo>();
		String sql="select * from providerinfo where proname=?";
		
		Object objs[]={pro.getProvidername()};
		res=this.exList(sql, objs);
		try {
			while(res.next()){
				int providerid = res.getInt("proid");
				String providername = res.getString("proname");
				String proman = res.getString("proman");
				String mobile = res.getString("mobile");
				String fax = res.getString("fax");
				String des= res.getString("des");
				String address = res.getString("address");
				Date prodate = res.getDate("prodate");
				
				ProviderInfo provider = new ProviderInfo(providerid,providername,des,proman,mobile,fax,address,prodate);
				providerlist.add(provider);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return providerlist;
	}
	//分页查询
	public List<ProviderInfo> getProBypage(ProviderInfo pro) {
		int page= pro.getPage();
 		int rows= pro.getSize();
 		int firstrow = (page-1)*rows;
 		int lastrow = page*rows+1;
 		providerlist = new ArrayList<ProviderInfo>();
		String sql = "select t.* from( select ProviderInfo.*,rownum rn from ProviderInfo where rownum<?) t  "
				+ "where t.rn>?";
		Object[] objs={lastrow,firstrow};
		res=this.exList(sql, objs);
		try {
			while(res.next()){
				int providerid = res.getInt("proid");
				String providername = res.getString("proname");
				String proman = res.getString("proman");
				String mobile = res.getString("mobile");
				String fax = res.getString("fax");
				String des= res.getString("des");
				String address = res.getString("address");
				Date prodate = res.getDate("prodate");
				
				ProviderInfo provider = new ProviderInfo(providerid,providername,des,proman,mobile,fax,address,prodate);
				providerlist.add(provider);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return providerlist;
		
	}
	//ͨ更新byid
	public int updateProrByid(ProviderInfo pro) {
		ProviderInfo provider = new ProviderInfo();
		String sql="update  providerinfo set  proname =?,proman=?,mobile=?,"
				+ "fax=?,des=?,address=? where proid=?";
		
		Object objs[]={pro.getProvidername(),pro.getProman(),pro.getMobile(),
				pro.getFax(),pro.getDes(),pro.getAddress(),	pro.getProviderid()};
		count=this.exupdate(sql, objs);
		
		return count;
	}
	//删除byid
	public int deleteProByid(ProviderInfo pro) {
		String sql ="delete from ProviderInfo where proid=?";
		Object[] objs={pro.getProviderid()};
		return this.exupdate(sql, objs);
	}
	//获得总数
	public int getProCount() {
		String sql = "select count(*) count from ProviderInfo";
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
		providerlist =new ArrayList<ProviderInfo>();
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
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return count;
	}

}
