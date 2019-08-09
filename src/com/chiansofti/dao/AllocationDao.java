package com.chiansofti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chiansofti.entity.Allocation;
import com.chiansofti.util.JDBCUtil;

//调拨表
public class AllocationDao {
	ResultSet rs = null;
	PreparedStatement ps = null;
	Connection conn = null;
	
	//查询调拨表数据
	public List<Allocation> select(String deptno,int state){
		String sql = null;
		List<Allocation> list =new ArrayList<>();
		try {
			conn=JDBCUtil.getMySqlConn();
			if(state==0){
				sql="select * from allocation where dealer = ?";
				ps=conn.prepareStatement(sql);
				ps.setObject(1, deptno);
			}else if(state<3){
				sql="select * from allocation where state=? and fdeptno = ?";
				ps=conn.prepareStatement(sql);
				ps.setObject(1, state-1);
				ps.setObject(2, deptno);
			}else if(state<=5){
				sql="select * from allocation where state=? and rdeptno = ?";
				ps=conn.prepareStatement(sql);
				ps.setObject(1, state-1);
				ps.setObject(2, deptno);
			}else {
				sql="select * from allocation where state=? ";
				ps=conn.prepareStatement(sql);
				ps.setObject(1, state-1);
			}
			rs=ps.executeQuery();
			while(rs.next()){
				Allocation allocation = new Allocation();
				allocation.setId(rs.getInt("id"));
				allocation.setAllocationId(rs.getString("allocation_id"));
				allocation.setDealer(rs.getString("dealer"));
				allocation.setCreate_time(rs.getDate("create_time"));
				allocation.setState(rs.getInt("state"));
				list.add(allocation);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
		return list;
	}
}
