package com.chiansofti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chiansofti.entity.Allocation;
import com.chiansofti.entity.Emp;
import com.chiansofti.util.JDBCUtil;

//调拨表
public class AllocationDao {
	ResultSet rs = null;
	PreparedStatement ps = null;
	Connection conn = null;
	TestConsumableDao consumableDao = new TestConsumableDao();
	
	
	//查询个人能操作的调拨表数据 
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
	
	//新增调拨
	public void addAllocation(List<Allocation> list,Emp emp){
		String sql="insert into allocation (detal_id,allocation_id,dealer"
					+",username,rdeptno,fdeptno,create_time,state) values(?,?,?,?,?,?,?,?)";
		try {
			conn=JDBCUtil.getMySqlConn();
			for (Allocation a : list) {
				ps=conn.prepareStatement(sql);
				ps.setObject(1, a.getDetalid());
				ps.setObject(2, a.getAllocationId());
				ps.setObject(3, a.getDealer());
				ps.setObject(4, a.getUsername());
				ps.setObject(5, a.getRdeptno());
				ps.setObject(6, a.getFdeptno());
				ps.setObject(7, a.getCreate_time());
				ps.setObject(8, emp.getPower());
				ps.execute();
				consumableDao.update(a.getDetalid());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.getMySqlConn();
		}
	}

	//审批时查询调拨数据
	public List<Allocation> selectAll(String id){
		List<Allocation> list =new ArrayList<>();
		String sql="select * from allocation where allocation_id=?";
		try {
			conn=JDBCUtil.getMySqlConn();
			ps=conn.prepareStatement(sql);
			ps.setObject(1, id);
			rs=ps.executeQuery();
			while (rs.next()) {
				Allocation a=new Allocation();
				a.setId(rs.getInt("id"));
				a.setAllocationId(id);
				a.setDetalid(rs.getInt("detal_id"));
				a.setDealer(rs.getString("dealer"));
				a.setUsername(rs.getString("username"));
				a.setFdeptno(rs.getString("fdeptno"));
				a.setRdeptno(rs.getString("rdeptno"));
				a.setState(rs.getInt("state"));
				list.add(a);
			}
			for (Allocation a : list) {
				a.setConsumable(consumableDao.selectId(a.getDetalid()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
		return list;
	}
	
	//审批时修改数据
	public int update(int state,String allocationid){
		String sql="update allocation set state =? where allocation_id=?";
		int result=0;
		try {
			conn=JDBCUtil.getMySqlConn();
			ps=conn.prepareStatement(sql);
			ps.setObject(1, state);
			ps.setObject(2, allocationid);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
		return result;
	}

	//审批完成插入详情表
	public boolean insertDetal(List<Allocation> list){
		boolean result=false;
		String sql="update consumables_detal set emp_name= ? ,deptno=?,state=? where id=?";
		try {
			conn=JDBCUtil.getMySqlConn();
			conn.setAutoCommit(false);
			ps=conn.prepareStatement(sql);
			for (Allocation a : list) {
				int state=0;
				if(a.getUsername()!=null&&!a.getUsername().equals("")){
					state=1;
				}
				ps.setObject(1, a.getUsername());
				ps.setObject(2, a.getRdeptno());
				ps.setObject(3, state);
				ps.setObject(4, a.getDetalid());
				ps.execute();
			}
			conn.commit();
			result=true;
		} catch (SQLException e) {
			try {
				conn.rollback();
				result=false;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
		return result;
	}
}
