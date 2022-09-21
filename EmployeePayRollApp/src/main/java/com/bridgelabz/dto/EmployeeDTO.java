package com.bridgelabz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO
{
    @NotEmpty
    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}$",message= "Employee Name Invalid")
    private String name;

    @Min(value =1000 , message="Minimum wage should be more than 500")
    private double salary;

}
