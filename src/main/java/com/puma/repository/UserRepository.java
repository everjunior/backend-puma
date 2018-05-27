package com.puma.repository;

import com.puma.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long>{
    List<User> findByNameIgnoreCaseContaining(String name);

}