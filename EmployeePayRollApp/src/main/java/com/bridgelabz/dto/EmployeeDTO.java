package com.bridgelabz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

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
    @Pattern(regexp = "(Male|Female|Other)?",message = "Invalid input for gender")
    private String gender;
    private List<String> department;
    LocalDate startDate;
    @NotBlank(message = "Enter proper note")
    String note;

}
