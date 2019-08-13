package com.chiansofti.service;

import java.util.List;

import com.chiansofti.entity.Allocation;
import com.chiansofti.entity.Emp;

public interface AllocationService {
	public List<Allocation> select(Emp emp);
	public void insert(String[] list,String[] user,String rfeptno,Emp emp);
}
