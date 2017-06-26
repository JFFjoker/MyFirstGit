package com.market.model;

import java.util.Date;

//供应商
public class ProviderInfo {
	private int providerid;//id
	private String providername;//供应名
	private String des;//供应描述
	private String proman;//联系人
	private String mobile;//手机
	private String fax;//传真
	private String address;//地址
	private Date prodate;//日期
	private int page ;
	private int size;
	public ProviderInfo(){}
	//少日期
	public ProviderInfo(int proid,String proname,String prodescription,
			String contact,String phone,String fax,String address){
		this.providerid=proid;
		this.providername=proname;
		this.des=prodescription;
		this.proman=contact;
		this.mobile=phone;
		this.fax=fax;
		this.address=address;
		
		
	}
	//全信息
	public ProviderInfo(int proid,String proname,String prodescription,
			String contact,String phone,String fax,String address,Date prodate){
		this.providerid=proid;
		this.providername=proname;
		this.des=prodescription;
		this.proman=contact;
		this.mobile=phone;
		this.fax=fax;
		this.address=address;
		this.prodate=prodate;
		
	}
	
	
	public int getProviderid() {
		return providerid;
	}
	public void setProviderid(int providerid) {
		this.providerid = providerid;
	}
	public String getProvidername() {
		return providername;
	}
	public void setProvidername(String providername) {
		this.providername = providername;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getProman() {
		return proman;
	}
	public void setProman(String proman) {
		this.proman = proman;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getProdate() {
		return prodate;
	}
	public void setProdate(Date prodate) {
		this.prodate = prodate;
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
