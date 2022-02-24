package com.oms.order.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
//	@ManyToOne()
//	@JoinColumn(name="order_id") //which column will act as foreign key?
//	private OrderVO orderVO;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;;
	}

//	public OrderVO getOrderVO() {
//		return orderVO;
//	}
//
//	public void setOrderVO(OrderVO orderVO) {
//		this.orderVO = orderVO;
//	}

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
