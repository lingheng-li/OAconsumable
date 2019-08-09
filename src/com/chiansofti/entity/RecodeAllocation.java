package com.chiansofti.entity;

import java.sql.Date;

public class RecodeAllocation {
	private int id;
	//调拨表编号
	private String allocationid;
	//审批人
	private String name;
	//审批时间
	private Date createtime;
	//几级审批
	private int state;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAllocationid() {
		return allocationid;
	}
	public void setAllocationid(String allocationid) {
		this.allocationid = allocationid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public RecodeAllocation() {
		super();
	}
	
}
