package com.puma.security.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.puma.model.User;
import com.puma.security.*;
import com.puma.repository.*;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(cpf);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with cpf '%s'.", cpf));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
