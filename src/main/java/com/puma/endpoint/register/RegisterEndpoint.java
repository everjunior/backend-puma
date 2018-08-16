package com.puma.endpoint.register;

import com.puma.model.Authority;
import com.puma.model.AuthorityName;
import com.puma.model.User;
import com.puma.repository.AuthorityRepository;
import com.puma.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.TemporalType;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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
            user.setLastPasswordResetDate(new Date());
            user.setEnabled(true);
            userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
