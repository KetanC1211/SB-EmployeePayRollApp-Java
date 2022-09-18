package com.bridgelabz.service;

import com.bridgelabz.controller.EmployeeController;
import com.bridgelabz.model.Employee;
import com.bridgelabz.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> listAllEmployee() {
        return employeeRepository.findAll();
    }

    public void saveEmployee(Employee user) {
        employeeRepository.save(user);
    }

    public Employee getEmployee(Integer id) {
        return employeeRepository.findById(id).get();
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}