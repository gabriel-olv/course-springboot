package br.com.gabrieldeoliveira.udemycoursejpoo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabrieldeoliveira.udemycoursejpoo.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
