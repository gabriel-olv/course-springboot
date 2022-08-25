package br.com.gabrieldeoliveira.udemycoursejpoo.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.gabrieldeoliveira.udemycoursejpoo.entities.User;
import br.com.gabrieldeoliveira.udemycoursejpoo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private UserRepository userRepository;
	
	@Bean
	public void dbSeed() {
		User u1 = new User(null, "Maria", "maria@gmail.com", "38 9 9988-7733", "12345");
		User u2 = new User(null, "João", "joao@gmail.com", "38 9 9923-2131", "12345");
		User u3 = new User(null, "Dario", "dario@gmail.com", "38 9 9728-1903", "12345");
		List<User> list = Arrays.asList(u1, u2, u3);
		userRepository.saveAll(list);
	}
}
