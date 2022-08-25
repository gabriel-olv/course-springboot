package br.com.gabrieldeoliveira.udemycoursejpoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabrieldeoliveira.udemycoursejpoo.entities.Product;
import br.com.gabrieldeoliveira.udemycoursejpoo.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	public Product findById(Long id) {
		Product obj = productRepository.findById(id).orElse(null);
		return obj;
	}
}
