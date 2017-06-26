package com.market.util;
//���������Ϣ

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import sun.security.krb5.Config;

public class ConfigManager {
	private static ConfigManager config;
	private static Properties pro;
	//��ʵ����
	public static ConfigManager getInstance(){
		if(config==null){
			config=new ConfigManager();
			
		}
		return config;
	}
	//�޲ι���
	public ConfigManager(){
		String profile ="database.properties";
		pro = new Properties();
		InputStream is = this.getClass().getClassLoader().getResourceAsStream(profile);
		try {
			pro.load(is);
			is.close();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	//���������Ϣ����
	public String getInfo(String key){
		String info=pro.getProperty(key);
		return info;
	}
}
