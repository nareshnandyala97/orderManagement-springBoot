package com.order.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.order.entity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Integer>{

}
