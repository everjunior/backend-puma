package com.puma.repository;

import com.puma.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAll();

    Post findOneById(Long id);
}
