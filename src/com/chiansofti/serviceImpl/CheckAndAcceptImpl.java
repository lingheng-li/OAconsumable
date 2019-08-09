package com.chiansofti.serviceImpl;

import java.util.List;
import java.util.Map;

import com.chiansofti.dao.CheckAndAcceptDao;
import com.chiansofti.service.CheckAndAcceptService;

/**
 * 2019年8月8日 @CH
 */
public class CheckAndAcceptImpl implements CheckAndAcceptService {

    @Override
    public Map<String, List<String>> getApplyList() {
	CheckAndAcceptDao caad=new CheckAndAcceptDao();
	return caad.getApplyList();
    }

}
