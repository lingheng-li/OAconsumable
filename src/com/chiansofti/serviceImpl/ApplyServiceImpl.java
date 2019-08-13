package com.chiansofti.serviceImpl;

import java.util.List;

import com.chiansofti.dao.ApplyDao;
import com.chiansofti.entity.Apply;
import com.chiansofti.entity.Emp;
import com.chiansofti.service.ApplyService;

public class ApplyServiceImpl implements ApplyService {
	ApplyDao ad=new ApplyDao();
	@Override
	public void add(Apply apply) {
		 ApplyDao ad=new ApplyDao();
		 ad.connection(apply);
		
	}
	@Override
	public List<Apply> select(Emp emp) {
		
		return ad.select(emp);
		
	}
	@Override
	public void updateApply(String tablenum) {
		ad.updateApply(tablenum);
	}

}
