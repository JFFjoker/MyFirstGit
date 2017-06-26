package com.market.model;

import java.util.Date;


public class BillInfo {
	private int billid;//编号
	private String proname;//商品名
	private int count;//数量
	private float money;//交易金额
	private String pay;//是否付款
	private String providername;//供应商
	private String prodes;//商品描述
	private Date date;//账单日期
	private int page ;
	private int size;
	public BillInfo(){}
	//少日期
	public BillInfo(int billid,String proname,int count,float money,
			String pay,String providername,String prodes){
		this.billid=billid;
		this.proname=proname;
		this.count=count;
		this.money=money;
		this.pay=pay;
		this.providername=providername;
		this.prodes=prodes;
		
	}
	//全信息
	public BillInfo(int billid,String proname,int count,float money,
			String pay,String providername,String prodes,Date date){
		this.billid=billid;
		this.proname=proname;
		this.count=count;
		this.money=money;
		this.pay=pay;
		this.providername=providername;
		this.prodes=prodes;
		this.date=date;
	}
	public int getBillid() {
		return billid;
	}
	public void setBillid(int billid) {
		this.billid = billid;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public String getProvidername() {
		return providername;
	}
	public void setProvidername(String providername) {
		this.providername = providername;
	}
	public String getProdes() {
		return prodes;
	}
	public void setProdes(String prodes) {
		this.prodes = prodes;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
