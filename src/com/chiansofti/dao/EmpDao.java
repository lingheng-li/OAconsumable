package com.chiansofti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chiansofti.entity.Emp;
import com.chiansofti.util.JDBCUtil;

public class EmpDao {
	ResultSet rs = null;
	PreparedStatement ps = null;
	Connection conn = null;
    // 登录
    public Emp Login(String empno, String pwd) {
		Emp emps = new Emp();
		Emp emp = null;
		String sql = "select * from emp where empno=? and pwd = ?";
		try {
		    conn = JDBCUtil.getMySqlConn();
		    ps = conn.prepareStatement(sql);
		    ps.setObject(1, empno);
		    ps.setObject(2, pwd);
		    rs = ps.executeQuery();
		    if (rs.next()) {
			emps.setEmpno(empno);
			emps.setDeptno(rs.getString("deptno"));
			emps.setEmpname(rs.getString("empname"));
			emps.setPower(rs.getInt("power"));
			emps.setPosition(rs.getString("position"));
			emps.setPwd(pwd);
			emp = emps;
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		} finally {
		    JDBCUtil.close(rs, ps, conn);
		}
		return emp;
    }

    public List<Emp> userList() {
	List<Emp> userList = new ArrayList<>();
	Emp emp = null;
	String sql = "select * from emp";
	try {
	    conn = JDBCUtil.getMySqlConn();
	    ps = conn.prepareStatement(sql);
	    rs = ps.executeQuery();
	    while (rs.next()) {
		emp = new Emp();
		emp.setId(rs.getInt("id"));
		emp.setEmpno(rs.getString("empno"));
		emp.setEmpname(rs.getString("empname"));
		emp.setDeptno(rs.getString("deptno"));
		emp.setPosition(rs.getString("position"));
		emp.setPower(rs.getInt("power"));
		userList.add(emp);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    JDBCUtil.close(rs, ps, conn);
	}
	return userList;
    }

	public int select(String dealer) {
		String sql="select power from emp where empname=?";
		int power=0;
	    try {
	    	conn = JDBCUtil.getMySqlConn();
			ps = conn.prepareStatement(sql);
			ps.setObject(1, dealer);
			rs = ps.executeQuery();
			if(rs.next()){
				power=rs.getInt("power");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
		return power;
	}
}
