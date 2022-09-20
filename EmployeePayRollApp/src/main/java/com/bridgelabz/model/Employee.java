package com.bridgelabz.model;


import com.bridgelabz.dto.EmployeeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double salary;

//    public Employee() {
//    }

//    public Employee(int id, String name, double salary) {
//        this.id =id;
//        this.name = name;
//        this.salary = salary;
//    }

    public Employee(Integer id, EmployeeDTO employeeDTO) {
        this.id = id;
        this.name = employeeDTO.getName();
        this.salary = employeeDTO.getSalary();
    }


//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }

    public Employee(EmployeeDTO employeeModelDTO){
        this.name=employeeModelDTO.getName();
        this.salary=employeeModelDTO.getSalary();
    }
}

