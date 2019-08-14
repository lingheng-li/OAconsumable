package com.chiansofti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.chiansofti.util.JDBCUtil;

public class RecodeDao {
	ResultSet rs = null;
	PreparedStatement ps = null;
	Connection conn = null;
	
	public void insert(String state,String allocationid,String name){
		String sql="insert into record (table_id,name,create_time,state) values(?,?,?,?)";
		try {
			conn=JDBCUtil.getMySqlConn();
			ps=conn.prepareStatement(sql);
			Date time =new Date(System.currentTimeMillis());
			ps.setObject(1, allocationid);
			ps.setObject(2, name);
			ps.setObject(3,time);
			ps.setObject(4,Integer.parseInt(state));
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
	}
}
