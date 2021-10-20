package com.example.EmployeePayrollApp.service;

import com.example.EmployeePayrollApp.dto.EmployeeDto;
import com.example.EmployeePayrollApp.entity.Employee;
import com.example.EmployeePayrollApp.exception.CustomException;
import com.example.EmployeePayrollApp.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a service class.It defines all the methods which are required in the controller class.
 */
@Slf4j
@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    private final List<Employee> employeePayRollDataList = new ArrayList<>();
    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    public List<Employee> getEmployeePayrollData() {
        return employeePayrollRepository.findAll();
    }

    public Employee getEmployeePayRollById(int empId) {
        return employeePayrollRepository.findById(empId).orElseThrow(()-> new CustomException("Employee with employeeId "+empId+" does not exists...!"));
    }

    public Employee addEmployee(EmployeeDto employeePayrollDto) {
        Employee employeePayRollData = null;
        employeePayRollData = new Employee(employeePayrollDto);
        log.debug("Emp Data" + employeePayRollData);
        employeePayRollDataList.add(employeePayRollData);
        return employeePayrollRepository.save(employeePayRollData);
    }

    public Employee UpdateEmployeePayroll(int empId, EmployeeDto employeePayrollDto) {
        Employee employeePayRollData = this.getEmployeePayRollById(empId);
        employeePayRollData.updateEmployeePayrollData(employeePayrollDto);
        return employeePayrollRepository.save(employeePayRollData);
    }

    public void deleteEmployeePayroll(int empId) {
        Employee employeePayRollData = this.getEmployeePayRollById(empId);
        employeePayrollRepository.delete(employeePayRollData);
    }
}
