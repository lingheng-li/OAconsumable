package com.chiansofti.serviceImpl;

import com.chiansofti.dao.ApplyDao;
import com.chiansofti.entity.Apply;
import com.chiansofti.service.ApplyService;

public class ApplyServiceImpl implements ApplyService {

	@Override
	public void add(Apply apply) {
		 ApplyDao ad=new ApplyDao();
		 ad.connection(apply);
		
	}

}
