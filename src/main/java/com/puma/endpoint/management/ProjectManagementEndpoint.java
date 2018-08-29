package com.puma.endpoint.management;

import com.puma.endpoint.util.DynamicUpdateUtil;
import com.puma.model.Project;
import com.puma.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("/sec/project")
public class ProjectManagementEndpoint {

    private final ProjectRepository projectDao;

    @Autowired
    public ProjectManagementEndpoint(ProjectRepository projectDao) {
        this.projectDao = projectDao;
    }

    @GetMapping(path ="/listAll")
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(projectDao.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/listById/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id){
        Optional<Project> project = projectDao.findById(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @PostMapping(path = "/new")
    public ResponseEntity<?> newProject(@RequestBody Project project){
        projectDao.save(project);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @PutMapping(path = "update/{id}")
    public ResponseEntity<?> updateProject (@PathVariable("id") Long id, @RequestBody Project project) {
        Project existing = projectDao.findOneById(id);
        DynamicUpdateUtil.copyNonNullProperties(project, existing);
        projectDao.save(existing);

        return new ResponseEntity<>(existing, HttpStatus.OK);
    }

}