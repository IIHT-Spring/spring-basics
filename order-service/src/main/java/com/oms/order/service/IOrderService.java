package com.oms.order.service;

import java.util.List;
import java.util.Optional;

import com.oms.order.vo.OrderVO;

public interface IOrderService {
	public OrderVO createOrder(OrderVO order);

	Optional<OrderVO> getOrder(Integer id);

	public List<OrderVO> getAllOrder();
}
