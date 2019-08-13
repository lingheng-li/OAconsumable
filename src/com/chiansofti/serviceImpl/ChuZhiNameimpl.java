package com.chiansofti.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chiansofti.entity.Allocation;
import com.chiansofti.entity.CZprincipal;
import com.chiansofti.entity.ChuZhiName;
import com.chiansofti.entity.WasteObject;
import com.chiansofti.service.ChuZhiNameser;
import com.chiansofti.dao.ChuZhiDao;

public class ChuZhiNameimpl implements ChuZhiNameser {
	ChuZhiDao chuzhiname = new ChuZhiDao();
	@Override
	
		public List<ChuZhiName> name() {
		
			return chuzhiname.name();
	}
	@Override
	public List<WasteObject> rest(String name) {
		// TODO 自动生成的方法存根
		return chuzhiname.rest(name);
	}
	@Override
	public List<CZprincipal> principal() {
		
		return chuzhiname.principal();
	}
	    
}

