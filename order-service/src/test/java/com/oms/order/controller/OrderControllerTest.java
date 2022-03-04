package com.oms.order.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.MethodParameter;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.oms.order.service.IOrderService;
import com.oms.order.vo.OrderVO;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {
	@InjectMocks
	OrderController controller; // dependent
	@Mock
	IOrderService service; // dependency

	@Mock
	BindingResult bindingResult;

	@Test
	void testCreateOrder() {
		OrderVO order = new OrderVO();
		order.setId(1);
		when(service.createOrder(order)).thenReturn(order);
		int id = controller.createOrder(order);
		assertEquals(1, id);
	}

	@Test
	void handleValidationExceptions() {
		MethodParameter parameters = null;
		MethodArgumentNotValidException ex = new MethodArgumentNotValidException(parameters, bindingResult);
		Map<String, String> errors = controller.handleValidationExceptions(ex);
		assertEquals(1, errors.size());
	}

}
