package com.chiansofti.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chiansofti.util.JDBCUtil;

public class test {

	public static void main(String[] args) {
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection conn =null;
		
		conn=JDBCUtil.getMySqlConn();
		System.out.println(conn);
		JDBCUtil.close(rs, ps, conn);
	}

}
