package com.chiansofti.service;

import java.util.List;

import com.chiansofti.entity.Emp;

public interface EmpService {
	public Emp login(String empno,String pwd);
	public List<Emp> userList();
}
