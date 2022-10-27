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

@CrossOrigin
@RestController
public class EmployeeController  {
    @Autowired
    IEmployeeService iEmployeeService;
    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> saveEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee addEmployee = iEmployeeService.add(employeeDTO);
        ResponseDTO responseDTO=new ResponseDTO("Employee added successfully", addEmployee);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/displayAll")
    public ResponseEntity<ResponseDTO> getALlEmployees() {
        List<Employee> employeeModel = iEmployeeService.list();
        ResponseDTO responseDTO=new ResponseDTO("Call for employee successful", employeeModel);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/display/{id}")
    public ResponseEntity<ResponseDTO> getEmployeeByID(@PathVariable int id) {
        Employee employeeModel = iEmployeeService.get(id);
        ResponseDTO responseDTO=new ResponseDTO("Call for Id successful", employeeModel);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/getByDepartment/{department}")
    public ResponseEntity<ResponseDTO> getEmployeeByID(@PathVariable String department) {
        List<Employee> employeeModel = iEmployeeService.getEmpByDepartment(department);
        ResponseDTO responseDTO=new ResponseDTO("Get Record by Department", employeeModel);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateById(@Valid @RequestBody EmployeeDTO employeeDTO, @PathVariable Integer id) {
        ResponseDTO responseDTO=new ResponseDTO("Updated "+id+" ...", iEmployeeService.updateByID(employeeDTO,id));
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteById(@PathVariable Integer id) {
        ResponseDTO responseDTO=new ResponseDTO("Deleting "+id+"...", iEmployeeService.delete(id));
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}