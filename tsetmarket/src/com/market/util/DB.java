package com.market.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//�����࣬�������
public class DB {
	
	protected Connection conn;
	protected Statement sta;
	protected PreparedStatement pres;
	protected ResultSet res;
	//�������
	public Connection getConn(){
		String driver=ConfigManager.getInstance().getInfo("driver");
		String url = ConfigManager.getInstance().getInfo("url");
		String user = ConfigManager.getInstance().getInfo("user");
		String password = ConfigManager.getInstance().getInfo("password");
		try {
			//����������
			Class.forName(driver);
			//�������ݿ�
			conn=DriverManager.getConnection(url, user, password);
			
			
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return conn;
	}
	//�ر���Դ
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
