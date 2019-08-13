package com.chiansofti.service;

import java.util.List;

import com.chiansofti.entity.CZprincipal;
import com.chiansofti.entity.ChuZhiName;
import com.chiansofti.entity.WasteObject;

public interface ChuZhiNameser {
	public List<ChuZhiName> name();

	public List<CZprincipal> principal();
	public	List<WasteObject> rest(String name);
}   