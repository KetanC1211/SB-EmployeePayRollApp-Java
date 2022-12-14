package com.bridgelabz.service;

import com.bridgelabz.dto.EmployeeDTO;
import com.bridgelabz.exception.EmployeeCustomException;
import com.bridgelabz.model.Employee;
import com.bridgelabz.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service

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
        return employeeRepository.findAll();
    }
    @Override
    public Employee get(Integer id) {
        return employeeRepository.findById(id).orElseThrow(()-> new EmployeeCustomException("Employee with ID "+id+ " Not Found"));
    }

    @Override
    public String updateByID(EmployeeDTO employeeDTO, Integer id) {
        if(employeeRepository.findById(id).isPresent()){
            Employee newEmp = new Employee(id, employeeDTO);
            employeeRepository.save(newEmp);
            return "Updated Id "+id+ " successfully";
        }
        else{
            return "Record not found for "+id+".";
        }
    }

    @Override
    public List<Employee> getEmpByDepartment(String department) {
        List<Employee> empList =employeeRepository.findByDepartment(department);
        return empList;
    }

    @Override
    public String delete(Integer id) {
        if(employeeRepository.findById(id).isPresent()){
            employeeRepository.deleteById(id);
            return "Deleted Successfully";
        }
        return "Record Not found";

    }

}