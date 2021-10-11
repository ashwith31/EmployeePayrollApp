package com.example.EmployeePayrollApp.dto;

import lombok.Data;
@Data
public class EmployeeDto {

    private String name;
    private long salary;

    public EmployeeDto(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }
}
