package br.com.gabrieldeoliveira.udemycoursejpoo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabrieldeoliveira.udemycoursejpoo.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
