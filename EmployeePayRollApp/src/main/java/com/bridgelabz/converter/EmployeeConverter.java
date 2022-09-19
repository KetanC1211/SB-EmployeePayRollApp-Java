package com.bridgelabz.converter;

import com.bridgelabz.dto.EmployeeDTO;
import com.bridgelabz.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeConverter {

    public EmployeeDTO entityToDto(Employee empObj){
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(empObj.getId());
        dto.setName(empObj.getName());
        dto.setSalary(empObj.getSalary());
        return dto;
    }

    public List<EmployeeDTO> entityToDto(List<Employee> empObj){
        return empObj.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }

    public Employee dtoToEntity(EmployeeDTO dto){
        Employee empObj = new Employee(dto);
        empObj.setId(dto.getId());
        empObj.setName(dto.getName());
        empObj.setSalary(dto.getSalary());
        return empObj;
    }

    public List<Employee> dtoToEntity(List<EmployeeDTO> dto){
        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
