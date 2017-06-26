package com.market.dao;

import java.util.List;
import java.util.Map;

import com.market.model.BillInfo;
import com.market.model.ProviderInfo;

public interface ProviderDao {
	//列表查询
	public List<ProviderInfo> prolist();
	//匹配查询
	public boolean getPro(ProviderInfo pro);
	//serch by condition
	public List<ProviderInfo> getProByCon(Map<String,String> map);
	//ͨ获得用户byid
	public ProviderInfo getProByid(ProviderInfo pro);
	//增加byid
	public int addPro(ProviderInfo pro);
	//是否存在byid
	public boolean isExist(ProviderInfo userinfo);
	//查询byname
	public List<ProviderInfo> getProByname(ProviderInfo pro);
	//分页查询
	public List<ProviderInfo> getProBypage(ProviderInfo pro);
	//ͨ更新byid
	public int updateProrByid(ProviderInfo pro);
	//删除byid
	public int deleteProByid(ProviderInfo pro);
	//获得总数
	public int getProCount();
}
