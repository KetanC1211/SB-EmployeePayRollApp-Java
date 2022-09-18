package com.bridgelabz.controller;

import com.bridgelabz.converter.EmployeeConverter;
import com.bridgelabz.dto.EmployeeDTO;
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
    @Autowired
    EmployeeConverter employeeConverter;
    @GetMapping("/displayAll")
    public List<EmployeeDTO> list() {
        List<Employee> employeeList = employeeService.listAllEmployee();
        return employeeConverter.entityToDto(employeeList);
    }

    @GetMapping("display/{id}")
    public ResponseEntity<EmployeeDTO> get(@PathVariable Integer id) {
        try {
            Employee empObj = employeeService.getEmployee(id);
            EmployeeDTO dto = employeeConverter.entityToDto(empObj);
            return new ResponseEntity<EmployeeDTO>(dto, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<EmployeeDTO>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public void add(@RequestBody EmployeeDTO employeeDTO) {
        Employee empObj = employeeConverter.dtoToEntity(employeeDTO);
        employeeService.saveEmployee(empObj);
    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<?> update(@RequestBody Employee empObj, @PathVariable Integer id) {
//        try {
//            Employee existUser = employeeService.getEmployee(id);
//            empObj.setId(id);
//            employeeService.saveEmployee(empObj);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (NoSuchElementException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody EmployeeDTO employeeDTO, @PathVariable Integer id) {
        try {
            Employee empObj = employeeConverter.dtoToEntity(employeeDTO);
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