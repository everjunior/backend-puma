package com.puma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.puma.model.User;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findOneById(Long id);
    List<User> findAll();
}
