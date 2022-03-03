package com.oms.order.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oms.order.vo.OrderVO;

@Repository
public interface OrderRepository extends JpaRepository<OrderVO, Integer> {
	String query = "select order.item from OrderVO as order where item=:item ";

	List<OrderVO> getByItem(String item);

	List<OrderVO> getByPriceGreaterThan(float price);

	@Query(query)
	List<String> getOrders(String item);
}
