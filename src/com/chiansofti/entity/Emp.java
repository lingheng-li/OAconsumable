package com.chiansofti.entity;

public class Emp {
	private int id;
	private String empno;
	private String empname;
	private String deptno;
	private String position;
	private int power;
	private String pwd;
	
	public Emp() {
		super();
	}
	
	public Emp(int id, String empno, String empname, String deptno, String position, int power, String pwd) {
		super();
		this.id = id;
		this.empno = empno;
		this.empname = empname;
		this.deptno = deptno;
		this.position = position;
		this.power = power;
		this.pwd = pwd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	@Override
	public String toString() {
		return "emp [id=" + id + ", empno=" + empno + ", empname=" + empname + ", deptno=" + deptno + ", position="
				+ position + "]";
	}
	
}
