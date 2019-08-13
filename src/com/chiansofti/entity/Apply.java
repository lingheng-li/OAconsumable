package com.chiansofti.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Apply {
	private String tablenum;//表单编号
	private String empno;//申请人编号
	private Date create_time;//申请时间
	private String consumable_code;//易耗品编码
	private String consumable_name;//易耗品名称
	private BigDecimal consumable_price;//易耗品价格
	private Integer consumable_number;//易耗品数量
	private int courtyard_project;//院管项目
	private int approval_status;//审批状态
	private BigDecimal totalPrice;//总价
	public String getTablenum() {
		return tablenum;
	}
	public void setTablenum(String tablenum) {
		this.tablenum = tablenum;
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getConsumable_code() {
		return consumable_code;
	}
	public void setConsumable_code(String consumable_code) {
		this.consumable_code = consumable_code;
	}
	public String getConsumable_name() {
		return consumable_name;
	}
	public void setConsumable_name(String consumable_name) {
		this.consumable_name = consumable_name;
	}
	public BigDecimal getConsumable_price() {
		return consumable_price;
	}
	public void setConsumable_price(BigDecimal bd) {
		this.consumable_price = bd;
	}
	public Integer getConsumable_number() {
		return consumable_number;
	}
	public void setConsumable_number(Integer consumablenumber) {
		this.consumable_number = consumablenumber;
	}
	public int getCourtyard_project() {
		return courtyard_project;
	}
	public void setCourtyard_project(int courtyard_project) {
		this.courtyard_project = courtyard_project;
	}
	public int getApproval_status() {
		return approval_status;
	}
	public void setApproval_status(int approval_status) {
		this.approval_status = approval_status;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Apply(String tablenum, String empno, Date create_time,
			String consumable_code, String consumable_name,
			BigDecimal consumable_price, Integer consumable_number,
			int courtyard_project, int approval_status,BigDecimal totalPrice ) {
		super();
		this.tablenum = tablenum;
		this.empno = empno;
		this.create_time = create_time;
		this.consumable_code = consumable_code;
		this.consumable_name = consumable_name;
		this.consumable_price = consumable_price;
		this.consumable_number = consumable_number;
		this.courtyard_project = courtyard_project;
		this.approval_status = approval_status;
		this.totalPrice=totalPrice;
	}
	public Apply() {
		super();
	}


}
