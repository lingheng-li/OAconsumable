package com.chiansofti.serviceImpl;

import java.util.List;
import java.util.Map;

import com.chiansofti.dao.CheckAndAcceptDao;
import com.chiansofti.service.CheckAndAcceptService;

/**
 * 2019年8月8日 @CH
 */
public class CheckAndAcceptImpl implements CheckAndAcceptService {
    CheckAndAcceptDao caad=new CheckAndAcceptDao();
    @Override
    public Map<String, List<String>> getApplyList(String deptno) {
//	CheckAndAcceptDao caad=new CheckAndAcceptDao();
	return caad.getApplyList(deptno);
    }

    @Override
    public void subCheck(String[][] data) {
	caad.subCheck(data);
    }

    @Override
    public Map<String, List<String>> getCurApplyDetail(String tablenum) {
	return caad.getCurApplyDetail(tablenum);
    }

    @Override
    public List<String> getCurApply(String tablenum) {
	return caad.getCurApply(tablenum);
    }
    
    

}
