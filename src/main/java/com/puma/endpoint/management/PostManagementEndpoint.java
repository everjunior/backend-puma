package com.puma.endpoint.management;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.puma.endpoint.util.DynamicUpdateUtil;
import com.puma.model.Post;
import com.puma.model.Project;
import com.puma.repository.PostRepository;
import com.puma.repository.UserRepository;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("/sec/post")
public class PostManagementEndpoint {

    private final PostRepository postDao;

    @Autowired
    public PostManagementEndpoint(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping(path ="/listAll")
    public ResponseEntity<?> listAll() throws JsonProcessingException {
        return new ResponseEntity<>(postDao.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/listById/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id){
        Optional<Post> post = postDao.findById(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PostMapping(path = "/new")
    public ResponseEntity<?> newPost(@RequestBody Post post) throws JsonProcessingException {
        postDao.save(post);
        //Object to JSON in String
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(post);
        System.out.println(jsonInString);

        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<?> deletePost(@PathVariable("id") Long id){
        Post post = postDao.findOneById(id);
        postDao.delete(post);
        return new ResponseEntity<>("Post deleted!", HttpStatus.OK);
    }

    @PutMapping(path = "update/{id}")
    public ResponseEntity<?> updatePost (@PathVariable("id") Long id, @RequestBody Post post) {

        Post existing = postDao.findOneById(id);
        DynamicUpdateUtil.copyNonNullProperties(post, existing);
        postDao.saveAndFlush(existing);

        return new ResponseEntity<>(existing, HttpStatus.OK);
    }

}