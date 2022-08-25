package br.com.gabrieldeoliveira.udemycoursejpoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabrieldeoliveira.udemycoursejpoo.entities.User;
import br.com.gabrieldeoliveira.udemycoursejpoo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		User obj = userRepository.findById(id).orElse(null);
		return obj;
	}
}
