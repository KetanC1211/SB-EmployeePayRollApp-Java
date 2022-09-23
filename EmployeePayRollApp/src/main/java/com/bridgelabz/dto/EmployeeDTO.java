package com.bridgelabz.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}$",message= "Employee Name Invalid")
    private String name;
    @Min(value =10000, message="Minimum wage should be more than 10000")
    private double salary;
    @Pattern(regexp = "(Male|Female|Other)?",message = "Invalid input for gender")
    private String gender;
    @NotEmpty(message = "Enter Atleast one Department")
    private List<String> department;
    @PastOrPresent(message = "Enter Valid Date or check Date Format")
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate startDate;
    @NotBlank(message = "Enter proper note")
    String note;

}
