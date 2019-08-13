package com.chiansofti.entity;

public class CZprincipal {
    //易消耗品编码
    private String code;   
    //对应购置计划审批表编号
    private String p_code;
    // 数量
    private Integer number;
    // 单价（元）
    private Double price;
    // 总价（元）
    private double totalPrice;
    // 使用人
    private String use_name;
    private String name;
    private String handle;
	public String getCode() {
		return code;
	}
	public String getHandle() {
		return handle;
	}
	public void setHandle(String handle) {
		this.handle = handle;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getP_code() {
		return p_code;
	}
	public void setP_code(String p_code) {
		this.p_code = p_code;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getUse_name() {
		return use_name;
	}
	public void setUse_name(String use_name) {
		this.use_name = use_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CZprincipal() {
	}
	public CZprincipal(String code, String p_code, Integer number,
			Double price, double totalPrice, String use_name, String name,
			String handle) {
		super();
		this.code = code;
		this.p_code = p_code;
		this.number = number;
		this.price = price;
		this.totalPrice = totalPrice;
		this.use_name = use_name;
		this.name = name;
		this.handle = handle;
	}
}
