package com.chiansofti.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.chiansofti.dao.AllocationDao;
import com.chiansofti.entity.Allocation;
import com.chiansofti.entity.Emp;
import com.chiansofti.service.AllocationService;

public class AllocationServiceImpl implements AllocationService{

	AllocationDao allocationDao = new AllocationDao();
	@Override
	//查询自己办理的调拨单以及
	public List<Allocation> select(Emp emp) {
		List<Allocation> list =new ArrayList<>();
		List<Allocation> list2 =new ArrayList<>();
		int state=0;
		list = allocationDao.select(emp.getEmpname(),state);
		if(emp.getPower()==0){
			if("a102".equals(emp.getDeptno())){
				state=6;
				list2=allocationDao.select(emp.getDeptno(),state);
				for (Allocation allocation : list2) {
					list.add(allocation);
				}
			}
			state=3;
		}else if(emp.getPower()==1){
			state=1;
			if("a102".equals(emp.getDeptno())){
				state=7;
				list2=allocationDao.select(emp.getDeptno(),state);
				for (Allocation allocation : list2) {
					list.add(allocation);
				}
				state=1;
			}else{
				list2=allocationDao.select(emp.getDeptno(),state);
				for (Allocation allocation : list2) {
					list.add(allocation);
				}
				state=4;
			}
		}else if(emp.getPower()==2){
			state=2;
			if("a102".equals(emp.getDeptno())){
				state=8;
				list2=allocationDao.select(emp.getDeptno(),state);
				for (Allocation allocation : list2) {
					list.add(allocation);
				}
				state=2;
			}else{
				list2=allocationDao.select(emp.getDeptno(),state);
				for (Allocation allocation : list2) {
					list.add(allocation);
				}
				state=5;
			}
		}
		list2=allocationDao.select(emp.getDeptno(),state);
		for (Allocation allocation : list2) {
			list.add(allocation);
		}
		return list;
	}

	@Override
	public Allocation update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Allocation insert() {
		// TODO Auto-generated method stub
		return null;
	}

}
