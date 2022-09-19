package com.bridgelabz.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
    private int id;
    private String name;
    private double salary;

    public EmployeeDTO() {
    }

    public EmployeeDTO(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}
