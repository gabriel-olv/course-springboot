package br.com.gabrieldeoliveira.udemycoursejpoo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabrieldeoliveira.udemycoursejpoo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
