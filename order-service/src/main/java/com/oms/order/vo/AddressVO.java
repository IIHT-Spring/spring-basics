package com.oms.order.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AddressVO {
	String house;
	@NotNull
	@Pattern(regexp = "^(.+)@(.+)$") // ram@gmail.com //pending
	String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}
}
