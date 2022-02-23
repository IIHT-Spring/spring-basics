package com.oms.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.order.vo.OrderVO;
@Service
public class OrderService implements IOrderService{
	@Autowired
	OrderRepository orderRepo;
	@Override
	public OrderVO createOrder(OrderVO order) {
		orderRepo.save(order);
		return order;
	}

}
