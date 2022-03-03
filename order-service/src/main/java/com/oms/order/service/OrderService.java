package com.oms.order.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.oms.order.vo.OrderVO;

@Service
public class OrderService implements IOrderService {
	@Autowired
	OrderRepository orderRepo;

	@Value("{schema}")
	String schema;

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public OrderVO createOrder(OrderVO order) {
		float updatedPrice = (float) (order.getPrice() * 0.9);
		order.setPrice(updatedPrice );
		orderRepo.save(order);
		int a = 1;
//		if (a == 1)
//			throw new IOException();
		return order;
	}

	@Override
	public Optional<OrderVO> getOrder(Integer id) {
		return orderRepo.findById(id);
	}

	@Override
	@Transactional
	public List<OrderVO> getAllOrder() {
		List<String> items = orderRepo.getOrders("iPhone");
		System.out.println(items.get(0));
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

	@Override
	public void updateOrder(@Valid OrderVO orderVO) {
		orderRepo.save(orderVO);
	}

}