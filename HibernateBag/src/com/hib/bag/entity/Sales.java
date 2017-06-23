package com.hib.bag.entity;

import java.util.Date;
import java.util.List;

public class Sales {
private String Orderid;
private Date Orderdate;
private List <Product> product;
public String getOrderid() {
	return Orderid;
}
public void setOrderid(String orderid) {
	Orderid = orderid;
}
public Date getOrderdate() {
	return Orderdate;
}
public void setOrderdate(Date date) {
	Orderdate = date;
}
public List<Product> getProduct() {
	return product;
}
public void setProduct(List<Product> product) {
	this.product = product;
}
}
