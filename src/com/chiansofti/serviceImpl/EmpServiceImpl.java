package com.chiansofti.serviceImpl;

import java.util.List;

import com.chiansofti.dao.EmpDao;
import com.chiansofti.entity.Emp;
import com.chiansofti.service.EmpService;

public class EmpServiceImpl implements EmpService{

	EmpDao empdao = new EmpDao();
	@Override
	public Emp login(String empno, String pwd) {
		Emp emp = null;
		emp=empdao.Login(empno, pwd);
		return emp;
	}
	@Override
	public List<Emp> userList() {
	    return empdao.userList();
	}
}
