package com.puma.endpoint.management;
import com.puma.endpoint.util.UpdateUserUtil;
import com.puma.model.User;
import com.puma.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("/sec")
public class UserManagementEndpoint {
    private final UserRepository userDAO;

    @Autowired
    public UserManagementEndpoint(UserRepository userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping(path ="/user/listAll")
    public ResponseEntity<?> listAll() {
        List<User> users = userDAO.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(path = "/user/listById/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id){
        Optional<User> user = userDAO.findById(id);
        user.get().setPassword(null);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping(path = "user/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody User user) {

        User existing = userDAO.findOneById(id);
        UpdateUserUtil.copyNonNullProperties(user, existing);
        userDAO.saveAndFlush(existing);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping(path = "user/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        User user = userDAO.findOneById(id);
        userDAO.delete(user);
        return new ResponseEntity<>("User deleted!", HttpStatus.OK);
    }
}
