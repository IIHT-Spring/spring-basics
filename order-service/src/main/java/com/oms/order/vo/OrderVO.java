package com.oms.order.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class OrderVO { // value object
	@NotBlank
	String item;
	@Min(value = 0)
	float price;
	AddressVO address;

	public AddressVO getAddress() {
		return address;
	}

	public void setAddress(AddressVO address) {
		this.address = address;
	}

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
