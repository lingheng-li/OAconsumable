package com.chiansofti.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
	private static Connection con;
	static Properties pro =null;//���԰�����ȡ�ʹ�����Դ�е���Ϣ
	static{
		//����JDBCUtil���ʱ�����
		pro =new Properties();
		try {
//			InputStream is = JDBCUtil.class.getResourceAsStream("db.properties");
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
			pro.load(is);
			is.close();
//			pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Connection getMySqlConn(){
		try {
			Class.forName(pro.getProperty("mysqlDriver"));
			con = DriverManager.getConnection(
					pro.getProperty("mysqlURL"),
					pro.getProperty("mysqlUser"),
					pro.getProperty("mysqlPwd")
					);
			return con;
		} catch (Exception e) {
			throw new RuntimeException(e + "���ݿ�����ʧ��");
		}
	}
	
	public static void close(ResultSet rs,PreparedStatement ps,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
