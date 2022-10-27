package com.bridgelabz.model;


import com.bridgelabz.dto.EmployeeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.stream.Location;
import java.time.LocalDate;
import java.util.List;


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
    private String profileImage;
    private double salary;
    private String gender;
//    @ElementCollection
    private String department;
    LocalDate startDate;
    String note;

    public Employee(Integer id, EmployeeDTO employeeDTO) {
        this.id = id;
        this.name = employeeDTO.getName();
        this.profileImage = employeeDTO.getProfileImage();
        this.salary = employeeDTO.getSalary();
        this.startDate=employeeDTO.getStartDate();
        this.department=employeeDTO.getDepartment();
        this.note=employeeDTO.getNote();
        this.gender=employeeDTO.getGender();
    }

    public Employee(EmployeeDTO employeeModelDTO){
        this.name=employeeModelDTO.getName();
        this.profileImage =employeeModelDTO.getProfileImage();
        this.salary=employeeModelDTO.getSalary();
        this.startDate=employeeModelDTO.getStartDate();
        this.department=employeeModelDTO.getDepartment();
        this.note=employeeModelDTO.getNote();
        this.gender=employeeModelDTO.getGender();
    }
}

