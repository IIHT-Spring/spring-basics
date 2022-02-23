package com.oms.order.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@Entity
public class AddressVO {
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Id
	Integer id;
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
