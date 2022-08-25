package br.com.gabrieldeoliveira.udemycoursejpoo.config;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.gabrieldeoliveira.udemycoursejpoo.entities.Order;
import br.com.gabrieldeoliveira.udemycoursejpoo.entities.User;
import br.com.gabrieldeoliveira.udemycoursejpoo.repositories.OrderRepository;
import br.com.gabrieldeoliveira.udemycoursejpoo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Bean
	public void dbSeed() {
		User u1 = new User(null, "Maria", "maria@gmail.com", "38 9 9988-7733", "12345");
		User u2 = new User(null, "João", "joao@gmail.com", "38 9 9923-2131", "12345");
		User u3 = new User(null, "Dario", "dario@gmail.com", "38 9 9728-1903", "12345");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u3);

		u1.getOrders().add(o1);
		u2.getOrders().add(o2);
		u3.getOrders().add(o3);
		
		List<User> users = Arrays.asList(u1, u2, u3);
		List<Order> orders = Arrays.asList(o1, o2, o3);
		
		userRepository.saveAll(users);
		orderRepository.saveAll(orders);
	}
}
