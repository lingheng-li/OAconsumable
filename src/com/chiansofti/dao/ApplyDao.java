package com.chiansofti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chiansofti.entity.Apply;
import com.chiansofti.util.JDBCUtil;

public class ApplyDao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	public void connection(Apply apply) {
		try{
		conn=JDBCUtil.getMySqlConn();
		String sql="insert into consumable_apply(tablenum,empno,create_time,consumable_code,consumable_name,consumable_price,consumable_number,courtyard_project,approval_status)values(?,?,?,?,?,?,?,?,?)";
		ps=conn.prepareStatement(sql);
		ps.setObject(1, apply.getTablenum());
		ps.setObject(2, apply.getEmpno());
		ps.setObject(3, apply.getCreate_time());
		ps.setObject(4, apply.getConsumable_code());
		ps.setObject(5, apply.getConsumable_name());
		ps.setObject(6, apply.getConsumable_price());
		ps.setObject(7, apply.getConsumable_number());
		ps.setObject(8, apply.getCourtyard_project());
		ps.setObject(9, apply.getApproval_status());
		ps.execute();
	}catch (Exception e) {
		e.printStackTrace();
	}finally{
		JDBCUtil.close(rs, ps, conn);
	 }
   }
}
