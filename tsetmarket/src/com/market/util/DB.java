package com.market.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//公共类，获得连接
public class DB {
	
	protected Connection conn;
	protected Statement sta;
	protected PreparedStatement pres;
	protected ResultSet res;
	//获得连接
	public Connection getConn(){
		String driver=ConfigManager.getInstance().getInfo("driver");
		String url = ConfigManager.getInstance().getInfo("url");
		String user = ConfigManager.getInstance().getInfo("user");
		String password = ConfigManager.getInstance().getInfo("password");
		try {
			//创建驱动器
			Class.forName(driver);
			//连接数据库
			conn=DriverManager.getConnection(url, user, password);
			
			
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return conn;
	}
	//关闭资源
	public void closeAll(){
		try {
			if(res!=null){
				res.close();
			}
			if(pres!=null){
				pres.close();
			}
			if(sta!=null){
				sta.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
