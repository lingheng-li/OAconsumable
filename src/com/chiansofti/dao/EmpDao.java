package com.chiansofti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chiansofti.entity.Emp;
import com.chiansofti.util.JDBCUtil;

public class EmpDao {

    // 登录
    public Emp Login(String empno, String pwd) {
	ResultSet rs = null;
	PreparedStatement ps = null;
	Connection conn = null;
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
}
