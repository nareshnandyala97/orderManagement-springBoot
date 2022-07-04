package com.order.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.order.entity.OrderEntity;
import com.order.exception.ResourceNotFoundException;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepo;

	@Override
	public Integer saveOrder(OrderEntity order) {
		OrderEntity saveOrder = orderRepo.save(order);
		return saveOrder.getId();
	}

	@Override
	public List<OrderEntity> getAllOrders() {
		// TODO Auto-generated method stub
		return orderRepo.findAll();
	}

	@Override
	public Optional<OrderEntity> getOrder(Integer id) {
		Optional<OrderEntity> order = orderRepo.findById(id);
		// TODO Auto-generated method stub
		return order;
	}

	@Override
	public void deleteOrder(Integer id) {
		orderRepo.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer updateEmployee(OrderEntity orderEntity, Integer id) {
		OrderEntity existingOrder=orderRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Order","id",id));
		existingOrder.setOrderName(orderEntity.getOrderName());
		existingOrder.setBrand(orderEntity.getBrand());
		orderRepo.save(existingOrder);		
		return existingOrder.getId();
	}

}
