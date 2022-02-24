package com.oms.order.service;

import java.io.IOException;
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
	@Transactional(rollbackOn = Exception.class)
	public OrderVO createOrder(OrderVO order) throws IOException {
		orderRepo.save(order);
		int a = 1;
		if (a == 1)
			throw new IOException();
		return order;
	}

	@Override
	public Optional<OrderVO> getOrder(Integer id) {
		return orderRepo.findById(id);
	}

	@Override
	@Transactional
	public List<OrderVO> getAllOrder() {
		return orderRepo.findAll();
	}

	@Override
	public void deleteOrder(Integer id) {
		orderRepo.deleteById(id);
	}

	@Override
	public List<OrderVO> getOrderByItem(String item) {
		return orderRepo.getByItem(item);
	}

}