package com.example.EmployeePayrollApp.service;

import com.example.EmployeePayrollApp.dto.EmployeeDto;
import com.example.EmployeePayrollApp.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
    @Override
    public List<Employee> getEmployeePayrollData() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1,new EmployeeDto("Ashwith", 35000)));
        return employeeList;
    }

    @Override
    public Employee getEmployeePayRollById(int empId) {
        Employee employee = null;
        employee = new Employee(1,new EmployeeDto("Ashwith", 35000));
        return employee;
    }

    @Override
    public Employee addEmployee(EmployeeDto employeePayrollDto) {
        Employee employee = null;
        employee = new Employee(1,employeePayrollDto);
        return employee;
    }

    @Override
    public Employee UpdateEmployeePayroll(EmployeeDto employeePayrollDto) {
        Employee employee = null;
        employee = new Employee(1,employeePayrollDto);
        return employee;
    }

    @Override
    public void deleteEmployeePayroll(int empid) {

    }
}
