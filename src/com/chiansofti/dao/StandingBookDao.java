package com.chiansofti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.chiansofti.entity.ConsumablesDetal;
import com.chiansofti.util.JDBCUtil;

public class StandingBookDao {

	public List<ConsumablesDetal> searchStandingBook() {
		Connection conn = null;
		PreparedStatement ps = null;
		//新增
		ResultSet rs = null;
		conn=JDBCUtil.getMySqlConn();
		List<ConsumablesDetal> list = new ArrayList<>();
		try {
			ps=conn.prepareStatement("SELECT * FROM consumables_detal d LEFT JOIN  consumable c ON d.consumable_code=c.consumable_code WHERE state<=1 ");
			rs=ps.executeQuery();
			while(rs.next()){
				ConsumablesDetal cbd = new ConsumablesDetal();
				//序号
				cbd.setId(rs.getInt("id"));
				//易耗品名称
				cbd.setConsumable_name(rs.getString("consumable_name"));
				//低值易耗品编码
				cbd.setConsumable_code(rs.getString("consumable_code"));
				//购置时间
				cbd.setAccept_time(rs.getString("accept_time"));
				//对应购置计划审批表编号
				cbd.setTablenum(rs.getString("tablenum"));
				//数量
				cbd.setConsumable_num(rs.getInt("consumable_num"));
				//单价
				cbd.setTax_price(rs.getDouble("tax_price"));
				//存放点
				cbd.setAddress(rs.getString("address"));
				//使用人
				cbd.setEmp_name(rs.getString("emp_name"));
				list.add(cbd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
		return list;
		
	}
	
}
