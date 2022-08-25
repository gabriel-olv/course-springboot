package br.com.gabrieldeoliveira.udemycoursejpoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabrieldeoliveira.udemycoursejpoo.entities.Order;
import br.com.gabrieldeoliveira.udemycoursejpoo.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> findAll() {
		return orderRepository.findAll();
	}
	
	public Order findById(Long id) {
		Order obj = orderRepository.findById(id).orElse(null);
		return obj;
	}
}
