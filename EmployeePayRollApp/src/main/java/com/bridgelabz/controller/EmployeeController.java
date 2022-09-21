package com.bridgelabz.controller;

import com.bridgelabz.dto.EmployeeDTO;
import com.bridgelabz.dto.ResponseDTO;
import com.bridgelabz.model.Employee;
import com.bridgelabz.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
public class EmployeeController  {
    @Autowired
    IEmployeeService iEmployeeService;
    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> getEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee addEmployee = iEmployeeService.add(employeeDTO);
        ResponseDTO responseDTO=new ResponseDTO("Employee added successfully", addEmployee);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/displayAll")
    public ResponseEntity<ResponseDTO> getEmployees() {
        List<Employee> employeeModel = iEmployeeService.list();
        ResponseDTO responseDTO=new ResponseDTO("Call for employee successful", employeeModel);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/display/{id}")
    public ResponseEntity<ResponseDTO> getEmployee(@PathVariable int id) {
        Employee employeeModel = iEmployeeService.get(id);
        ResponseDTO responseDTO=new ResponseDTO("Call for Id successful", employeeModel);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateById(@Valid @RequestBody EmployeeDTO employeeDTO, @PathVariable Integer id) {
        ResponseDTO responseDTO=new ResponseDTO("Updated Id successful", iEmployeeService.updateByID(employeeDTO,id));
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable Integer id) {
        ResponseDTO responseDTO=new ResponseDTO("Deleting "+id+"...", iEmployeeService.delete(id));
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}