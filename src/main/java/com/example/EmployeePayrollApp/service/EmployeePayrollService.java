package com.example.EmployeePayrollApp.service;

import com.example.EmployeePayrollApp.dto.EmployeeDto;
import com.example.EmployeePayrollApp.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    private List<Employee> employeeList = new ArrayList<>();

    @Override
    public List<Employee> getEmployeePayrollData() {
        return employeeList;
    }

    @Override
    public Employee getEmployeePayRollById(int empId) {
        return employeeList.get(empId-1);
    }

    @Override
    public Employee addEmployee(EmployeeDto employeePayrollDto) {
        Employee employee = null;
        employee = new Employee(employeeList.size()+1,employeePayrollDto);
        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee UpdateEmployeePayroll(int empId, EmployeeDto employeePayrollDto) {
        Employee employee = this.getEmployeePayRollById(empId);
        employee.setName(employeePayrollDto.getName());
        employee.setSalary(employeePayrollDto.getSalary());
        employeeList.set(empId-1,employee);
        return employee;
    }

    @Override
    public void deleteEmployeePayroll(int empid) {
        employeeList.remove(empid-1);
    }
}
