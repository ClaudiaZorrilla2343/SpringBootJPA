package com.javatechnolessons.demo.controllers;

import com.javatechnolessons.demo.interfaces.IController;
import com.javatechnolessons.demo.model.Employee;
import com.javatechnolessons.demo.repository.IEmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/app")
public class EmployeeController implements IController<Employee> {
    @Autowired
    private IEmployeeJpaRepository iEmployeeJpaRepository;

    @GetMapping("/employee/{id}")
    public Employee findById(@PathVariable Long id) {
        return iEmployeeJpaRepository.findById(id).orElse(null);
    }

    @GetMapping("/employee")
    public List<Employee> findAll() {
        return iEmployeeJpaRepository.findAll();
    }

    @PostMapping("/employee")
    public void save(Employee entity) {
        iEmployeeJpaRepository.save(entity);
    }

    @DeleteMapping("/employee/{id}")
    public void deleteById(@PathVariable Long id) {
        iEmployeeJpaRepository.deleteById(id);
    }

    @DeleteMapping("/employee")
    public void deleteAll() {
        iEmployeeJpaRepository.deleteAll();
    }

}
