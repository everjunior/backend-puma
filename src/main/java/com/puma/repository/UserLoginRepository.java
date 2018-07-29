package com.puma.repository;

import com.puma.model.UserLogin;
import org.springframework.data.repository.CrudRepository;

public interface UserLoginRepository extends CrudRepository<UserLogin, String> {

    UserLogin findByLogin(String login);

}
