package com.puma.endpoint.register;

import com.puma.model.Authority;
import com.puma.model.AuthorityName;
import com.puma.model.User;
import com.puma.repository.AuthorityRepository;
import com.puma.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController(value = "/register")
public class RegisterEndpoint {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @PostMapping
    public ResponseEntity<Object> registerUser(@RequestBody User user){
        Authority savedAuthority = authorityRepository.getOne(Long.valueOf(1));
        user.setAuthorities(Collections.singletonList(savedAuthority));

        User savedUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    public List<Authority> setAuthorityForNewUser(){
        Authority authority = new Authority();
        List<Authority> authorities = new ArrayList<>();
        authority.setName(AuthorityName.valueOf("ROLE_ADMIN"));
        authorities.add(authority);
        return authorities;
    }
}
