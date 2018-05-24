package com.puma.endpoint;

import com.puma.error.CustomErrorType;
import com.puma.model.User;
import com.puma.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("users")
public class UserEndpoint {

    private final DateUtil dateUtil;

    @Autowired
    public UserEndpoint(DateUtil dateUtil) {
        this.dateUtil = dateUtil;
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        System.out.println(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(User.userList, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save (@RequestBody User user){
        User.userList.add(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") int id){
        User user = new User();
        user.setId(id);
        int index = User.userList.indexOf(user);
        if (index == -1) {
            return new ResponseEntity<>(new CustomErrorType("User not found!"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Object>(User.userList.get(index), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> delete (@RequestBody User user){
        User.userList.remove(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update (@RequestBody User user){
        User.userList.remove(user);
        User.userList.add(user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
