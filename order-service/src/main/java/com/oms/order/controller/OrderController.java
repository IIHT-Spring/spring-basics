package com.oms.order.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.oms.order.vo.OrderVO;

@RestController
public class OrderController {// singleton, spring bean
	List<OrderVO> orders = new ArrayList<>();
	@GetMapping("/order")
	public Integer getOrder(@RequestParam("item") String item) {
		System.out.println(item);
		return 1;
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
	public String createOrder(@Valid @RequestBody OrderVO orderVO) {
		System.out.println("controller=" + this.hashCode());
		System.out.println(orderVO.hashCode());
		System.out.println(orderVO.getPrice());
		System.out.println(orderVO.getAddress().getHouse());
		orders.add(orderVO);
		return "created";
	}
}
