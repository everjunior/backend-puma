package com.puma.endpoint.register;

import com.puma.model.Authority;
import com.puma.model.User;
import com.puma.repository.AuthorityRepository;
import com.puma.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collections;
import java.util.Date;

@RestController(value = "/register")
public class RegisterEndpoint {

    private final UserRepository userRepository;

    private final AuthorityRepository authorityRepository;

    @Autowired
    public RegisterEndpoint(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    @PostMapping
    public ResponseEntity<Object> registerUser(@RequestBody User user){
            Authority savedAuthority = authorityRepository.getOne(Long.valueOf(1));
            user.setAuthorities(Collections.singletonList(savedAuthority));
            user.setLastPasswordResetDate(new Date());
            user.setEnabled(true);
            userRepository.save(user);
        return new ResponseEntity<>("User created successfully!", HttpStatus.CREATED);
    }
}
