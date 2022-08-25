package br.com.gabrieldeoliveira.udemycoursejpoo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabrieldeoliveira.udemycoursejpoo.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
