package com.market.util;
//获得配置信息

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import sun.security.krb5.Config;

public class ConfigManager {
	private static ConfigManager config;
	private static Properties pro;
	//单实例化
	public static ConfigManager getInstance(){
		if(config==null){
			config=new ConfigManager();
			
		}
		return config;
	}
	//无参构造
	public ConfigManager(){
		String profile ="database.properties";
		pro = new Properties();
		InputStream is = this.getClass().getClassLoader().getResourceAsStream(profile);
		try {
			pro.load(is);
			is.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	//获得配置信息方法
	public String getInfo(String key){
		String info=pro.getProperty(key);
		return info;
	}
}
