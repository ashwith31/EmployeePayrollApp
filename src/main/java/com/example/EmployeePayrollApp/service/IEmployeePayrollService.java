package com.example.EmployeePayrollApp.service;

import com.example.EmployeePayrollApp.dto.EmployeeDto;
import com.example.EmployeePayrollApp.entity.Employee;

import java.util.List;

public interface IEmployeePayrollService {

    List<Employee> getEmployeePayrollData();

    Employee getEmployeePayRollById(int empId);

    Employee addEmployee(EmployeeDto employeePayrollDto);

    Employee UpdateEmployeePayroll(EmployeeDto employeePayrollDto);

    void deleteEmployeePayroll(int empid);
}
