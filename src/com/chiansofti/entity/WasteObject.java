package com.chiansofti.entity;

import java.math.BigDecimal;
import java.util.Objects;
   
public class WasteObject {
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


    public String getCode() {
        return code;
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

    public void setPrice(double d) {
        this.price = d;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double d) {
        this.totalPrice = d;
    }

    public String getUse_name() {
        return use_name;
    }

    public void setUse_name(String use_name) {
        this.use_name = use_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WasteObject)) return false;
        WasteObject that = (WasteObject) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(p_code, that.p_code) &&
                Objects.equals(number, that.number) &&
                Objects.equals(price, that.price) &&
                Objects.equals(totalPrice, that.totalPrice) &&
                Objects.equals(use_name, that.use_name);
    }

    @Override
    public int hashCode() {

        return Objects.hash( code, p_code, number, price, totalPrice, use_name);
    }

    @Override
    public String toString() {
        return "WasteObject{" +
                ", code='" + code + '\'' +
                ", p_code='" + p_code + '\'' +
                ", number=" + number +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                ", use_name='" + use_name + '\'' +
                '}';
    }
}
