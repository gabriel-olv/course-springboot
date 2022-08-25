package br.com.gabrieldeoliveira.udemycoursejpoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabrieldeoliveira.udemycoursejpoo.entities.Category;
import br.com.gabrieldeoliveira.udemycoursejpoo.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
	
	public Category findById(Long id) {
		Category obj = categoryRepository.findById(id).orElse(null);
		return obj;
	}
}
