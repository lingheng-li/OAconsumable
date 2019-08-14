package com.chiansofti.entity;

public class ConsumablesDetal {
	//编号
	private int id;
	//表单编号
	private String tablenum;
	//易耗品编号
	private String consumable_code;
	//数量
	private int consumable_num;
	//不含税单价
	private double tax_price;
	//增值税
	private double added_tax;
	//存放点
	private String address;
	//使用人
	private String emp_name;
	//所属部门编号
	private String deptno;
	//使用状态（0，未使用，1使用）
	private int state;
	//处置原因
	private String handle;
	//采购人
	private String purchaser;
	//采购时间
	private String accept_time;
	private String  consumable_name;
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
	public int getConsumable_num() {
		return consumable_num;
	}
	public void setConsumable_num(int consumable_num) {
		this.consumable_num = consumable_num;
	}
	public double getTax_price() {
		return tax_price;
	}
	public void setTax_price(double tax_price) {
		this.tax_price = tax_price;
	}
	public double getAdded_tax() {
		return added_tax;
	}
	public void setAdded_tax(double added_tax) {
		this.added_tax = added_tax;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getHandle() {
		return handle;
	}
	public void setHandle(String handle) {
		this.handle = handle;
	}
	public String getPurchaser() {
		return purchaser;
	}
	public void setPurchaser(String purchaser) {
		this.purchaser = purchaser;
	}
	public String getAccept_time() {
		return accept_time;
	}
	public void setAccept_time(String accept_time) {
		this.accept_time = accept_time;
	}
	public String getConsumable_name() {
		return consumable_name;
	}
	public void setConsumable_name(String consumable_name) {
		this.consumable_name = consumable_name;
	}
	public ConsumablesDetal(int id, String tablenum, String consumable_code,
			int consumable_num, double tax_price, double added_tax,
			String address, String emp_name, String deptno, int state,
			String handle, String purchaser, String accept_time,
			String consumable_name) {
		super();
		this.id = id;
		this.tablenum = tablenum;
		this.consumable_code = consumable_code;
		this.consumable_num = consumable_num;
		this.tax_price = tax_price;
		this.added_tax = added_tax;
		this.address = address;
		this.emp_name = emp_name;
		this.deptno = deptno;
		this.state = state;
		this.handle = handle;
		this.purchaser = purchaser;
		this.accept_time = accept_time;
		this.consumable_name = consumable_name;
	}
	public ConsumablesDetal() {
		super();
	}
	
}
