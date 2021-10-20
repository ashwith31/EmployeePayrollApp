package com.example.EmployeePayrollApp.entity;

import com.example.EmployeePayrollApp.dto.EmployeeDto;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_Id")
    private int empId;

    @Column(name = "name")
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> departments;

    public Employee(EmployeeDto employeePayrollDto) {
        this.updateEmployeePayrollData(employeePayrollDto);
    }

    public Employee() {
    }

    public void updateEmployeePayrollData(EmployeeDto employeePayrollDto) {
        this.name = employeePayrollDto.name;
        this.salary = employeePayrollDto.salary;
        this.gender = employeePayrollDto.gender;
        this.startDate = employeePayrollDto.startDate;
        this.note = employeePayrollDto.note;
        this.profilePic = employeePayrollDto.profilePic;
        this.departments = employeePayrollDto.department;
    }
}
