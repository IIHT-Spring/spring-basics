package com.oms.order.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.oms.order.vo.OrderVO;
@ExtendWith(MockitoExtension.class)
class OrderServiceTest {
	@InjectMocks
	OrderService service;
	
	@Mock
	OrderRepository repository;
	@Test
	void testCreateOrder() {
		OrderVO order= new OrderVO();
		order.setId(1);
		when(repository.save(order)).thenReturn(order);
		service.createOrder(order);
		assertEquals(1, order.getId());
	}

	@Test
	void testGetOrder() {
	}

}
