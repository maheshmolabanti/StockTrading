package com.example.stocktrading;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderBookController {

	@Autowired
	private OrderBookService orderBookService;

	@PostMapping("/add")
	public String addOrder(@RequestBody Order order) {
		orderBookService.addOrder(order);
		return "Order added successfully";
	}
}
