package com.chiansofti.serviceImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.chiansofti.dao.AllocationDao;
import com.chiansofti.dao.RecodeDao;
import com.chiansofti.dao.TestConsumableDao;
import com.chiansofti.entity.Allocation;
import com.chiansofti.entity.ConsumablesDetal;
import com.chiansofti.entity.Emp;
import com.chiansofti.service.AllocationService;

public class AllocationServiceImpl implements AllocationService{

	AllocationDao allocationDao = new AllocationDao();
	TestConsumableDao consumableDao = new TestConsumableDao();
	RecodeDao recodeDao = new RecodeDao();
	
	@Override
	//查询自己办理的调拨单以及
	public List<Allocation> select(Emp emp) {
		List<Allocation> list =new ArrayList<>();
		List<Allocation> list2 =new ArrayList<>();
		int state=0;
		list = allocationDao.select(emp.getEmpname(),state);
		if(emp.getPower()==0){
			if("d102".equals(emp.getDeptno())){
				state=6;
				list2=allocationDao.select(emp.getDeptno(),state);
				for (Allocation allocation : list2) {
					list.add(allocation);
				}
			}
			state=3;
		}else if(emp.getPower()==1){
			state=1;
			if("d102".equals(emp.getDeptno())){
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
			if("d102".equals(emp.getDeptno())){
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

	//审批时调用
	public int update(String state,String allocationid,Emp emp) {
		int a=Integer.parseInt(state);
		boolean flag = true;
		int result=0;
		if(a==8){
			List<Allocation> list=allocationDao.selectAll(allocationid);
			flag = allocationDao.insertDetal(list);
		}
		if(flag){
			result=allocationDao.update(a, allocationid);
			recodeDao.insert(state,allocationid,emp.getEmpname());
		}
		return result;
	}

	//新增调拨
	@Override
	public void insert(String[] datas,String[] user, String rdeptno,Emp emp) {
		List<Allocation> list= new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int year= calendar.get(calendar.YEAR);
		String aid="A-"+year+"-"+System.currentTimeMillis();
		Date time =new Date(System.currentTimeMillis());
		for (int i = 0; i < datas.length; i++) {
			Allocation a = new Allocation();
			int id = Integer.parseInt(datas[i]);
			a.setDetalid(id);
			a.setAllocationId(aid);
			a.setDealer(emp.getEmpname());
			a.setUsername(user[i]);
			a.setRdeptno(rdeptno);
			a.setFdeptno(emp.getDeptno());
			a.setCreate_time(time);
			list.add(a);
		}
		allocationDao.addAllocation(list,emp);
	}
	
	public ConsumablesDetal selectConsum(String code,Emp emp){
		ConsumablesDetal consumable=consumableDao.select(code,emp);
		return consumable;
	}
	
	//查询调拨表
	public List<Allocation> select(String id){
		List<Allocation> list =allocationDao.selectAll(id);
		return list;
	}
}
