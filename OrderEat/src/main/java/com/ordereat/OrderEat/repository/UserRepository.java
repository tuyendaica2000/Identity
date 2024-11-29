package com.ordereat.OrderEat.repository;

import com.ordereat.OrderEat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long > {
    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
}
