package com.oms.order.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.oms.order.service.IOrderService;
import com.oms.order.vo.OrderVO;

@RestController
public class OrderController {// singleton, spring bean
	@Autowired //field injection
	IOrderService orderService;
	@GetMapping("/order/{id}")
	public Optional<OrderVO> getOrder(@PathVariable Integer id) {
		Optional<OrderVO> order = orderService.getOrder(id);
		return order ;
	}
	
	@DeleteMapping("/order/{id}")
	public Integer deleteOrder(@PathVariable String id) {
		System.out.println(id);
		return 1;
	}
	
	@GetMapping("/order")
	public List<OrderVO> getOrders() {
		return orderService.getAllOrder();
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		errors.put("timestamp", new Date().toString());
		return errors;
	}

	@PostMapping("/order") // HTTP method+path = REST API endpoint
	public Integer createOrder(@Valid @RequestBody OrderVO orderVO) {
		OrderVO savedOrder = orderService.createOrder(orderVO);
		return savedOrder.getId();
	}
}
