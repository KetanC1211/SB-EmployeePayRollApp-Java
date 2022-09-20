package com.bridgelabz.service;

import com.bridgelabz.dto.EmployeeDTO;
import com.bridgelabz.model.Employee;
import com.bridgelabz.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService implements IEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee add(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO);
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public List<Employee> list() {
        List<Employee> employeeModels = employeeRepository.findAll();
        return employeeModels;
    }
    @Override
    public Employee get(Integer id) {
        Optional<Employee> employeeModel = employeeRepository.findById(id);
        return employeeModel.get();
    }

    @Override
    public Employee updateByID(EmployeeDTO employeeDTO, Integer id) {
        if(employeeRepository.findById(id).isPresent()){
            Employee newEmp = new Employee(id, employeeDTO);
            Employee search = employeeRepository.save(newEmp);
            return search;
        }
        else{
            return null;
        }
    }

    @Override
    public String delete(Integer id) {
        if(employeeRepository.findById(id).isPresent()){
            employeeRepository.deleteById(id);
            String message = "Deleted succesfully";
            return message;
        }
        else{
            return "No record Found";
        }
    }
}