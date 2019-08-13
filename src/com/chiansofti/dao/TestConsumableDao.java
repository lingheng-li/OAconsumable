package com.chiansofti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chiansofti.entity.TestConsumable;
import com.chiansofti.util.JDBCUtil;

//测试用
public class TestConsumableDao {
	ResultSet rs = null;
	PreparedStatement ps = null;
	Connection conn = null;
	public TestConsumable select(String code){
		TestConsumable consum=new TestConsumable();
		String sql="select * from consumables_detal where consumable_code= ? and state<= 1";
		try {
			conn=JDBCUtil.getMySqlConn();
			ps=conn.prepareStatement(sql);
			ps.setObject(1, code);
			rs=ps.executeQuery();
			if(rs.first()){
				consum.setId(rs.getInt("id"));
				consum.setConsumable_code(code);
				consum.setTablenum(rs.getString("tablenum"));
				consum.setTax_price(rs.getDouble("tax_price"));
				consum.setUser(rs.getString("emp_name"));
			}
			sql="select * from consumable where consumable_code=?";
			ps=conn.prepareStatement(sql);
			ps.setObject(1, code);
			rs=ps.executeQuery();
			if(rs.next()){
				consum.setConsumable_name(rs.getString("consumable_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return consum;
	}
	
	public TestConsumable selectId(int id){
		TestConsumable consum=new TestConsumable();
		String sql="select * from consumables_detal where id=?";
		conn=JDBCUtil.getMySqlConn();
		try {
			ps=conn.prepareStatement(sql);
			ps.setObject(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				consum.setId(id);
				consum.setConsumable_code(rs.getString("consumable_code"));
				consum.setTablenum(rs.getString("tablenum"));
				consum.setTax_price(rs.getDouble("tax_price"));
				consum.setUser(rs.getString("emp_name"));
			}
			sql="select * from consumable where consumable_code=?";
			ps=conn.prepareStatement(sql);
			ps.setObject(1, consum.getConsumable_code());
			rs=ps.executeQuery();
			if(rs.next()){
				consum.setConsumable_name(rs.getString("consumable_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return consum;
	}
}
