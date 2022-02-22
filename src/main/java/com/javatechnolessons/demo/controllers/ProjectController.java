package com.javatechnolessons.demo.controllers;

import com.javatechnolessons.demo.interfaces.IController;
import com.javatechnolessons.demo.model.Project;
import com.javatechnolessons.demo.repository.IProjectJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/project")
public class ProjectController implements IController<Project> {
    @Autowired
    private IProjectJpaRepository iProjectJpaRepository;

    @GetMapping("/project/{id}")
    public Project findById(@PathVariable Long id) {
        return iProjectJpaRepository.findById(id).orElse(null);
    }

    @GetMapping("/project")
    public List<Project> findAll() {
        return iProjectJpaRepository.findAll();
    }

    @PostMapping("/project")
    public void save(Project entity) {
        iProjectJpaRepository.save(entity);
    }

    @DeleteMapping("/project/{id}")
    public void deleteById(@PathVariable Long id) {
        iProjectJpaRepository.deleteById(id);
    }

    @DeleteMapping("/project")
    public void deleteAll() {
        iProjectJpaRepository.deleteAll();
    }
}