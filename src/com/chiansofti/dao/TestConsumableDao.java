package com.chiansofti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chiansofti.entity.ConsumablesDetal;
import com.chiansofti.entity.Emp;
import com.chiansofti.util.JDBCUtil;

//测试用
public class TestConsumableDao {
	ResultSet rs = null;
	PreparedStatement ps = null;
	Connection conn = null;
	public ConsumablesDetal select(String code,Emp emp){
		ConsumablesDetal consum=new ConsumablesDetal();
		String sql="SELECT * FROM consumables_detal d LEFT JOIN  consumable c ON "
				+ "d.consumable_code=c.consumable_code WHERE state<=1 and d.consumable_code=? and d.deptno=?";
		try {
			conn=JDBCUtil.getMySqlConn();
			ps=conn.prepareStatement(sql);
			ps.setObject(1, code);
			ps.setObject(2, emp.getDeptno());
			rs=ps.executeQuery();
			if(rs.first()){
				consum.setId(rs.getInt("id"));
				consum.setConsumable_code(code);
				consum.setTablenum(rs.getString("tablenum"));
				consum.setTax_price(rs.getDouble("tax_price"));
				consum.setEmp_name(rs.getString("emp_name"));
				consum.setConsumable_name(rs.getString("consumable_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
		return consum;
	}
	
	public ConsumablesDetal selectId(int id){
		ConsumablesDetal consum=new ConsumablesDetal();
		String sql="SELECT * FROM consumables_detal d LEFT JOIN  consumable c "
				+ "ON d.consumable_code=c.consumable_code where id=?";
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
				consum.setEmp_name(rs.getString("emp_name"));
				consum.setConsumable_name(rs.getString("consumable_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
		return consum;
	}
	public void update(int id){
		String sql ="update consumables_detal set state=15 where id=?";
		conn=JDBCUtil.getMySqlConn();
		try {
			ps=conn.prepareStatement(sql);
			ps.setObject(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
	}
}
