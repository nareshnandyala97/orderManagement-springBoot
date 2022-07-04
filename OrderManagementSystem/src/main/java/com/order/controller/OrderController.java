package com.order.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.order.entity.OrderEntity;
import com.order.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;

	@PostMapping(value = "/saveOrder")
	public Integer saveStudet(@RequestBody OrderEntity order) {
		Integer id = orderService.saveOrder(order);
		System.out.println("student id" + id);
		return id;

	}

	@GetMapping(value = "/getAllOrders")
	public List<OrderEntity> getAllStudents() {

		return orderService.getAllOrders();
	}

	@GetMapping(value = "/getOrder/{id}")
	public Optional<OrderEntity> getStudent(@PathVariable Integer id) {
		// Optional<EmployeeEntity> student=employeeService.getStudent(id);
		return orderService.getOrder(id);
	}

	@DeleteMapping(value = "deleteOrder/{id}")
	public ResponseEntity<OrderEntity> deleteStudent(@PathVariable Integer id) {

		ResponseEntity<OrderEntity> response = new ResponseEntity<>(HttpStatus.OK);

		try {
			orderService.deleteOrder(id);
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return response;
	}

	@PutMapping(value = "updateOrder/{id}")
	public ResponseEntity<OrderEntity> updateStudent(@PathVariable Integer id,
			@RequestBody OrderEntity employeeEntity) {

		ResponseEntity<OrderEntity> response = new ResponseEntity<>(HttpStatus.OK);

		try {
			orderService.updateEmployee(employeeEntity, id);
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return response;
	}

}
