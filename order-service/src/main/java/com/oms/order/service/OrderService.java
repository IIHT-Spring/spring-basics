package com.oms.order.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.order.vo.OrderVO;

@Service
public class OrderService implements IOrderService {
	@Autowired
	OrderRepository orderRepo;

	@Override
	@Transactional
	public OrderVO createOrder(OrderVO order) {
		orderRepo.save(order);
		int a = 1;
//		if (a == 1)
//			throw new RuntimeException();
		return order;
	}

	@Override
	public Optional<OrderVO> getOrder(Integer id) {
		return orderRepo.findById(id);
	}

	@Override
	public List<OrderVO> getAllOrder() {
		return orderRepo.findAll();
	}

} 