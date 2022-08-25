package br.com.gabrieldeoliveira.udemycoursejpoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	public User insert(User obj) {
		return userRepository.save(obj);
	}
	
	public void remove(Long id) {
		userRepository.deleteById(id);
	}
	
	@Transactional
	public User update(Long id, User data) {
		User user = userRepository.findById(id).orElse(null);
		user.updateWith(data);
		return user;
	}
}
