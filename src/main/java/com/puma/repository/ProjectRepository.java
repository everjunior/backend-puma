package com.puma.repository;

import com.puma.model.Post;
import com.puma.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findAll();

    Project findOneById(Long id);
}
