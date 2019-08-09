package com.chiansofti.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Allocation {
	
	private int id;
	//详情表编号
	private String detalid;
	//调拨表编号
	private String allocationId;
	//调拨人
	private String dealer;
	//预使用人
	private String username;
	//调入部门
	private String rdeptno;
	//原部门
	private String fdeptno;
	//办理时间
	private Date create_time;
	//审批状态
	private int state;
	
	//审批记录
	List<RecodeAllocation> list = new ArrayList<>();
	//调拨易耗品
	TestConsumable ConsumList = new TestConsumable();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDetalid() {
		return detalid;
	}
	public void setDetalid(String detalid) {
		this.detalid = detalid;
	}
	public String getAllocationId() {
		return allocationId;
	}
	public void setAllocationId(String allocationId) {
		this.allocationId = allocationId;
	}
	public String getDealer() {
		return dealer;
	}
	public void setDealer(String dealer) {
		this.dealer = dealer;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRdeptno() {
		return rdeptno;
	}
	public void setRdeptno(String rdeptno) {
		this.rdeptno = rdeptno;
	}
	public String getFdeptno() {
		return fdeptno;
	}
	public void setFdeptno(String fdeptno) {
		this.fdeptno = fdeptno;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Allocation() {
		super();
	}
	
	
}
