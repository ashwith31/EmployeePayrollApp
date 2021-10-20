package com.example.EmployeePayrollApp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
public class EmployeeDto {
    @NotNull
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "name should contains atleast 2 characters...first letter should be caps")
    public String name;

    @NotNull
    @Min(value = 600, message = "Salary must be greater than 600")
    @Max(value = 50000, message = "salary must be less than 50000")
    public long salary;

    @NotNull
    @Pattern(regexp = "male|female", message = "gender should be either male or female")
    public String gender;

    @NotNull
    @JsonFormat(pattern = "dd MMM yyyy")
    @PastOrPresent(message = "Date should be present date or past date")
    public LocalDate startDate;

    @NotBlank(message = "note should not be empty")
    public String note;

    @NotBlank(message = "profile pic should not be empty")
    public String profilePic;

    @NotNull
    public List<String> department;
}
