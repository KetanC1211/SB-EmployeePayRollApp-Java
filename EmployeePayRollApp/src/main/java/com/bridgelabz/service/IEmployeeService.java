package com.bridgelabz.service;

import com.bridgelabz.dto.EmployeeDTO;
import com.bridgelabz.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IEmployeeService {

    public List<Employee> list();

    public Employee add(EmployeeDTO employeeDTO);

    public Employee get( Integer id);

    public String delete(Integer id);

    Object updateByID(EmployeeDTO employeeDTO, Integer id);

}
