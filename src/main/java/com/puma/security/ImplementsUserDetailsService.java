package com.puma.security;

import com.puma.model.UserLogin;
import com.puma.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class ImplementsUserDetailsService implements UserDetailsService {

    @Autowired
    private UserLoginRepository userLoginRepository;


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserLogin userLogin = userLoginRepository.findByLogin(login);

        if(userLogin == null){
            throw new UsernameNotFoundException("Usuário não encontrado!");
        }

        return userLogin;
    }
}
