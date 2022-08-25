package br.com.gabrieldeoliveira.udemycoursejpoo.config;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.gabrieldeoliveira.udemycoursejpoo.entities.Category;
import br.com.gabrieldeoliveira.udemycoursejpoo.entities.Order;
import br.com.gabrieldeoliveira.udemycoursejpoo.entities.Product;
import br.com.gabrieldeoliveira.udemycoursejpoo.entities.User;
import br.com.gabrieldeoliveira.udemycoursejpoo.entities.enums.OrderStatus;
import br.com.gabrieldeoliveira.udemycoursejpoo.repositories.CategoryRepository;
import br.com.gabrieldeoliveira.udemycoursejpoo.repositories.OrderRepository;
import br.com.gabrieldeoliveira.udemycoursejpoo.repositories.ProductRepository;
import br.com.gabrieldeoliveira.udemycoursejpoo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Bean
	public void dbSeed() {
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		List<Category> categories = Arrays.asList(cat1, cat2, cat3);
		List<Product> products = Arrays.asList(p1, p2, p3, p4, p5);
		
		productRepository.saveAll(products);
		categoryRepository.saveAll(categories);
		
		cat1.getProducts().addAll(Arrays.asList(p2, p3, p4));
		cat2.getProducts().addAll(Arrays.asList(p1, p5));
		cat3.getProducts().addAll(Arrays.asList(p3, p4));
		
		categoryRepository.saveAll(categories);
		
		User u1 = new User(null, "Maria", "maria@gmail.com", "38 9 9988-7733", "12345");
		User u2 = new User(null, "João", "joao@gmail.com", "38 9 9923-2131", "12345");
		User u3 = new User(null, "Dario", "dario@gmail.com", "38 9 9728-1903", "12345");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u3);

		u1.getOrders().add(o1);
		u2.getOrders().add(o2);
		u3.getOrders().add(o3);
		
		List<User> users = Arrays.asList(u1, u2, u3);
		List<Order> orders = Arrays.asList(o1, o2, o3);
		
		userRepository.saveAll(users);
		orderRepository.saveAll(orders);
	}
}
