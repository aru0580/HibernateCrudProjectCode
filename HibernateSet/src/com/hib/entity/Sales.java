package com.hib.entity;

import java.util.Date;
import java.util.Set;

//import com.hib.entity.Product;

public class Sales {
	private String Orderid;
	private Date Orderdate;
	private Set <Product> product;
	public String getOrderid() {
		return Orderid;
	}
	public void setOrderid(String orderid) {
		Orderid = orderid;
	}
	public Date getOrderdate() {
		return Orderdate;
	}
	public void setOrderdate(Date orderdate) {
		Orderdate = orderdate;
	}
	public Set<Product> getProduct() {
		return product;
	}
	public void setProduct(Set<Product> product) {
		this.product = product;
	}
}
