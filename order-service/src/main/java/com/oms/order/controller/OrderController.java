package com.oms.order.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.oms.order.service.IOrderService;
import com.oms.order.vo.OrderVO;

@RestController
@RequestMapping("/order/")
public class OrderController {// singleton, spring bean
	@Autowired // field injection
	IOrderService orderService;

	@GetMapping("{id}")
	public Optional<OrderVO> getOrder(@PathVariable Integer id) {
		Optional<OrderVO> order = orderService.getOrder(id);
		return order;
	}

	@GetMapping("item/{item}")
	public List<OrderVO> getOrderByItem(@PathVariable String item) {
		return orderService.getOrderByItem(item);
	}

	@PutMapping("{id}")
	public ResponseEntity<OrderVO> updateOrder(@Valid @RequestBody OrderVO orderVO, @PathVariable Integer id) {
		ResponseEntity<OrderVO> responseEntity = new ResponseEntity<OrderVO>(HttpStatus.OK);
		orderVO.setId(id);
		try {
			orderService.updateOrder(orderVO);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<OrderVO>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

	@DeleteMapping("{id}")
	public ResponseEntity<OrderVO> deleteOrder(@PathVariable Integer id) {
		System.out.println(id);
		ResponseEntity<OrderVO> responseEntity = new ResponseEntity<OrderVO>(HttpStatus.OK);
		try {
			orderService.deleteOrder(id);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<OrderVO>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

	@GetMapping
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

	@PostMapping // HTTP method+path = REST API endpoint
	public Integer createOrder(@Valid @RequestBody OrderVO orderVO)  {
		OrderVO savedOrder = null;
		savedOrder = orderService.createOrder(orderVO);
		return savedOrder.getId();
	}
}
