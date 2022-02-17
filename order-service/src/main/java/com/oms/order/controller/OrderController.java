package com.oms.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oms.order.vo.OrderVO;

@RestController
public class OrderController {
	@GetMapping("/order")
	public Integer getOrder() {
		return 1;
	}

	@PostMapping("/order")  //HTTP method+path = REST API endpoint
	public String createOrder(@RequestBody OrderVO orderVO) {
		System.out.println(orderVO.getItem());
		System.out.println(orderVO.getPrice());
		System.out.println(orderVO.getAddress().getHouse());
		return "created";
	}
}
