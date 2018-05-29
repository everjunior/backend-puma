package com.puma.endpoint;

import com.puma.error.CustomErrorType;
import com.puma.error.ResourceNotFoundException;
import com.puma.model.User;
import com.puma.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserEndpoint {
    private final UserRepository userDAO;

    @Autowired
    public UserEndpoint(UserRepository userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(userDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id){
        Optional<User> user = userDAO.findById(id);
        if (!user.isPresent()) { //TODO: modificar logica
            throw new ResourceNotFoundException("User not found!");
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(path = "/findByName/{name}")
    public ResponseEntity<?> findUsersByName(@PathVariable String name){
        return new ResponseEntity<Object>(userDAO.findByNameIgnoreCaseContaining(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save (@Valid @RequestBody User user){
        return new ResponseEntity<>(userDAO.save(user), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        if (id == null) { //TODO: modificar logica
            throw new ResourceNotFoundException("User not found!");
        }
        userDAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update (@RequestBody User user){
        if (user.getId() == null) { //TODO: modificar logica
            throw new ResourceNotFoundException("User not found!");
        }
        userDAO.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
