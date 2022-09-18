package com.bridgelabz.controller;

import com.bridgelabz.model.Employee;
import com.bridgelabz.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/displayAll")
    public List<Employee> list() {
        return employeeService.listAllEmployee();
    }

    @GetMapping("display/{id}")
    public ResponseEntity<Employee> get(@PathVariable Integer id) {
        try {
            Employee empObj = employeeService.getEmployee(id);
            return new ResponseEntity<Employee>(empObj, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public void add(@RequestBody Employee empObj) {
        employeeService.saveEmployee(empObj);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody Employee empObj, @PathVariable Integer id) {
        try {
            Employee existUser = employeeService.getEmployee(id);
            empObj.setId(id);
            employeeService.saveEmployee(empObj);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
    }
}