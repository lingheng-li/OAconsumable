package com.chiansofti.service;

import java.util.List;

import com.chiansofti.entity.Apply;
import com.chiansofti.entity.Emp;

public interface ApplyService {
	
     void add(Apply apply);
     
	List<Apply> select(Emp emp);
	
	void updateApply(String tablenum);
	
	void updateStatus(String tablenum);
}
