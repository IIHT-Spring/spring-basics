package com.oms.order.vo;

public class OrderVO { //value object 
	String item;
	float price;
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}
