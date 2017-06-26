package com.market.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.market.dao.UserDao;
import com.market.model.UserInfo;
import com.market.util.DB;


public class UserDaoImpl extends DB implements UserDao{
	private List<UserInfo> userlist;
	private int count;
	private UserInfo userinfo;
	//列表查询
	public List<UserInfo> userlist(){
		userlist = new ArrayList<UserInfo>();
		String sql="select * from userinfo ";
		
		Object objs[]={};
		res=this.exList(sql, objs);
		try {
			while(res.next()){
				int no = res.getInt("userid");
				String name = res.getString("username");
				String sex = res.getString("sex");
				int age = res.getInt("age");
				String phone = res.getString("mobile");
				String address = res.getString("address");
				String auth = res.getString("auth");
				
				UserInfo user = new UserInfo(no,name,sex,age,phone,address,auth);
				userlist.add(user);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return userlist;
	}
	//匹配查询
	public boolean getUser(UserInfo user){
		boolean flag=false;
		String sql="select * from userInfo where username=? and password=?";
		Object[] objs ={user.getUsername(),user.getPassword()};
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
	//ͨ获得byid
	public UserInfo getUserByid(UserInfo user){
		String sql="select * from userInfo where userid=?";
		Object[] objs ={user.getUserid()};
		res=this.exList(sql, objs);
		try {
			while(res.next()){
				int no = res.getInt("userid");
				String name = res.getString("username");
				String pwd = res.getString("password");
				String sex = res.getString("sex");
				int age = res.getInt("age");
				String phone = res.getString("mobile");
				String address = res.getString("address");
				String auth = res.getString("auth");
				//Date date = res.getDate("birthday");
				userinfo = new UserInfo(no,name,pwd,sex,age,phone,address,auth);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return userinfo;
		
	}
	//ͨ获得用户byname
	public UserInfo getOneUserByname(UserInfo user){
		//userinfo = new UserInfo();
		String sql="select * from userInfo where username=? ";
		Object[] objs ={user.getUsername()};
		res=this.exList(sql, objs);
		try {
			while(res.next()){
				int no = res.getInt("userid");
				String name = res.getString("username");
				String pwd = res.getString("password");
				String sex = res.getString("sex");
				int age = res.getInt("age");
				String phone = res.getString("mobile");
				String address = res.getString("address");
				String permission = res.getString("auth");
				userinfo = new UserInfo(no,name,pwd,sex,age,phone,address,permission);
				//System.out.println(no+name+pwd+sex+age+phone+address+permission);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return userinfo;
	};
	//是否存在byid
	public boolean isExist(UserInfo user){
		boolean flag = false;
		String sql="select * from userInfo where userid=?";
		Object[] objs ={user.getUserid()};
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
	//列表byname
	public List<UserInfo> getUserByname(UserInfo userinfo){
		userlist = new ArrayList<UserInfo>();
		String sql="select * from userInfo where username=? ";
		Object[] objs ={userinfo.getUsername()};
		res=this.exList(sql, objs);
		try {
			while(res.next()){
				int no = res.getInt("userid");
				String name = res.getString("username");
				String sex = res.getString("sex");
				int age = res.getInt("age");
				String phone = res.getString("mobile");
				String address = res.getString("address");
				String permission = res.getString("auth");
				UserInfo user = new UserInfo(no,name,sex,age,phone,address,permission);
				userlist.add(user);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return userlist;
	}
	//总数
	public int getUserCount(){
		String sql = "select count(*) count from userinfo";
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
		};
	//分页查询
	public List<UserInfo> getUserBypage(UserInfo userinfo){
		int page= userinfo.getPage();
 		int rows= userinfo.getSize();
 		int firstrow = (page-1)*rows;
 		int lastrow = page*rows+1;
 		userlist = new ArrayList<UserInfo>();
		String sql = "select t.* from( select userinfo.*,rownum rn from userinfo where rownum<?) t  "
				+ "where t.rn>?";
		Object[] objs={lastrow,firstrow};
		res=this.exList(sql, objs);
		try {
			while(res.next()){
				int no = res.getInt("userid");
				String name = res.getString("username");
				String sex = res.getString("sex");
				int age = res.getInt("age");
				String phone = res.getString("mobile");
				String address = res.getString("address");
				String auth = res.getString("auth");
				
				UserInfo user = new UserInfo(no,name,sex,age,phone,address,auth);
				userlist.add(user);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return userlist;
	};
	//查询优化
	public ResultSet exList(String sql,Object[] objs){
		getConn();
		userlist =new ArrayList<UserInfo>();
		try {
			pres=conn.prepareStatement(sql);
			for(int i=0;i<objs.length;i++){
			pres.setObject(i+1, objs[i]);	
			}
			res=pres.executeQuery();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return res;
	}
	
	
	//增删改
	//增加byid
	@Override
	public int adduser(UserInfo user) {
		String sql = "insert into userinfo (userid,username,password,sex,age,mobile,address,auth) values(?,?,?,?,?,?,?,?)";
		Object[] objs = {user.getUserid(),user.getUsername(),user.getPassword(),user.getSex(),
				user.getAge(),user.getMobile(),user.getAddress(),user.getAuth()};
		count = this.exupdate(sql, objs);
		return count;
	}
	//ͨ更新byid
	public int updateUserByid(UserInfo user){
		
		
		String sql = "update userinfo  set username = ?  ,sex = ?,"
				+ "age = ?,mobile = ?,address = ? ,auth = ?,birthday=? where userid=?";

		Object[] objs = {user.getUsername(),user.getSex(),
				user.getAge(),user.getMobile(),user.getAddress(),user.getAuth(),user.getBirthday(),user.getUserid()};
		count = this.exupdate(sql, objs);
		return count;
		
	}
	//更新密码byid
	public int updatePwd(UserInfo user){
		String sql = "update userinfo  set password = ?  where userid=?";

		Object[] objs = {user.getPassword(),user.getUserid()};
		return this.exupdate(sql, objs);
		
		
	}
	//删除byid
	public int deleteUserByid(UserInfo user){
		String sql ="delete from userinfo where userid=?";
		Object[] objs={user.getUserid()};
		return this.exupdate(sql, objs);
			};
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

	
	
}
