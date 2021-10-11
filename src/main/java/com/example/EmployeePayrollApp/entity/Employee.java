package com.example.EmployeePayrollApp.entity;

import com.example.EmployeePayrollApp.dto.EmployeeDto;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Employee {

    @Id
    private int id;
    private String name;
    private long salary;

    public Employee(int empId, EmployeeDto employeePayrollDto) {
        this.id = empId;
        this.name = employeePayrollDto.getName();
        this.salary = employeePayrollDto.getSalary();
    }

    public Employee() {

    }
}
