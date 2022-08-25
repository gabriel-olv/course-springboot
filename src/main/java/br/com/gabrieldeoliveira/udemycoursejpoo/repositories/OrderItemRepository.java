package br.com.gabrieldeoliveira.udemycoursejpoo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabrieldeoliveira.udemycoursejpoo.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
