package com.oms.order.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.oms.order.vo.OrderVO;

public interface IOrderService {
	public OrderVO createOrder(OrderVO order);

	Optional<OrderVO> getOrder(Integer id);

	public List<OrderVO> getAllOrder();

	public void deleteOrder(Integer id);

	public List<OrderVO> getOrderByItem(String item);

	public void updateOrder(@Valid OrderVO orderVO);
}
