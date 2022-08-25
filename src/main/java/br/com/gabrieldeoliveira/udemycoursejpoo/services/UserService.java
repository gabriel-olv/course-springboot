package br.com.gabrieldeoliveira.udemycoursejpoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gabrieldeoliveira.udemycoursejpoo.entities.User;
import br.com.gabrieldeoliveira.udemycoursejpoo.repositories.UserRepository;
import br.com.gabrieldeoliveira.udemycoursejpoo.services.exceptions.DatabaseException;
import br.com.gabrieldeoliveira.udemycoursejpoo.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
		User obj = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		return obj;
	}

	public User insert(User obj) {
		return userRepository.save(obj);
	}

	public void remove(Long id) {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	@Transactional
	public User update(Long id, User data) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id));
		user.updateWith(data);
		return user;
	}
}
