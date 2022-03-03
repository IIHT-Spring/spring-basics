package com.oms.order.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.oms.order.service.IOrderService;
import com.oms.order.vo.OrderVO;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {
	@InjectMocks
	OrderController controller; //dependent
	@Mock
	IOrderService service; //dependency

	@Test
	void testCreateOrder() {
		OrderVO order = new OrderVO();
		order.setId(1);
		when(service.createOrder(order)).thenReturn(order);
		int id = controller.createOrder(order);
		assertEquals(1, id);
	}

}
