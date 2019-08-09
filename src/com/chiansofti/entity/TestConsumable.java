package com.chiansofti.entity;

//调拨用的详情表数据
public class TestConsumable {
	
	private int id;
	//申请表编号
	private String tablenum;
	//易耗品编码
	private String consumable_code;
	//易耗品名称
	private String consumable_name;
	//单价
	private double tax_price;
	//部门编号
	private String deptno;
	
	public TestConsumable() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTablenum() {
		return tablenum;
	}
	public void setTablenum(String tablenum) {
		this.tablenum = tablenum;
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
	public double getTax_price() {
		return tax_price;
	}
	public void setTax_price(double tax_price) {
		this.tax_price = tax_price;
	}
	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	
}
