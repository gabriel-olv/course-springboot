package br.com.gabrieldeoliveira.udemycoursejpoo.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabrieldeoliveira.udemycoursejpoo.entities.User;

@RestController
@RequestMapping("/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User u1 = new User(1L, "Maria", "maria@gmail.com", "38 9 9988-7733", "12345");
		User u2 = new User(2L, "João", "joao@gmail.com", "38 9 9923-2131", "12345");
		User u3 = new User(3L, "Dario", "dario@gmail.com", "38 9 9728-1903", "12345");
		return ResponseEntity.ok(Arrays.asList(u1, u2, u3));
	}
}
