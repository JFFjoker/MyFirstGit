package com.market.dao;
import java.util.*;

import com.market.model.UserInfo;
public interface UserDao {
	//列表查询
	public List<UserInfo> userlist();
	//匹配查询
	public boolean getUser(UserInfo user);
	
	//ͨ获得用户byid
	public UserInfo getUserByid(UserInfo user);
	//ͨ获得用户byname
	public UserInfo getOneUserByname(UserInfo user);
	//增加byid
	public int adduser(UserInfo userinfo);
	//是否存在byid
	public boolean isExist(UserInfo userinfo);
	//查询byname
	public List<UserInfo> getUserByname(UserInfo userinfo);
	//分页查询
	public List<UserInfo> getUserBypage(UserInfo userinfo);
	//ͨ更新byid
	public int updateUserByid(UserInfo user);
	//更新密码byid
	public int updatePwd(UserInfo user);
	//删除byid
	public int deleteUserByid(UserInfo user);
	//获得总数
	public int getUserCount();
	
}
