package com.oms.order.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oms.order.vo.OrderVO;
@Repository
public interface OrderRepository extends JpaRepository<OrderVO, Integer>{

}
