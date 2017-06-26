package com.market.model;

import java.util.Date;

//用户信息
public class UserInfo {
	private int userid;//id
	private String username;//名字
	private String password;//密码
	private String sex;//性别
	private int age;//年龄
	private String mobile;//电话
	private String address;//地址
	private String auth;//权限
	private Date birthday;//生日
	private int page;
	private int size;
	//private int count;
	//构造函数
	public UserInfo(){}
	//for login
	public UserInfo(String username,String password){
		this.username=username;
		this.password=password;
	}
	
	public UserInfo(int userid,String username,
			String sex,int age,String mobile,String address,String auth){
		this.userid=userid;
		this.username=username;
		this.sex=sex;
		this.age=age;
		this.mobile=mobile;
		this.address=address;
		this.auth=auth;
		
	}
	public UserInfo(int userno,String username,String password,
			String sex,int age,String phone,String address,	String auth){
		this.userid=userno;
		this.username=username;
		this.password=password;
		this.sex=sex;
		this.age=age;
		this.mobile=phone;
		this.address=address;
		this.auth=auth;
		
	}
	//全信息
	public UserInfo(int userno,String username,String password,
			String sex,int age,String phone,String address,	String auth,Date date){
		this.userid=userno;
		this.username=username;
		this.password=password;
		this.sex=sex;
		this.age=age;
		this.mobile=phone;
		this.address=address;
		this.auth=auth;
		this.birthday=date;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}


	
}
