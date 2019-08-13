package com.chiansofti.serviceImpl;

import java.util.List;

import com.chiansofti.dao.StandingBookDao;
import com.chiansofti.entity.ConsumablesDetal;
import com.chiansofti.service.StandingBookService;

public class StandingBookServiceImpl implements  StandingBookService{

	@Override
	public List<ConsumablesDetal> searchStandingBook() {
		StandingBookDao slDao = new StandingBookDao();
		List<ConsumablesDetal> c = slDao.searchStandingBook();
		
		return c;
	}
	
}
