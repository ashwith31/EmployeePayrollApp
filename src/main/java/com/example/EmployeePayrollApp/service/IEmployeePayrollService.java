package com.example.EmployeePayrollApp.service;

import com.example.EmployeePayrollApp.dto.EmployeeDto;
import com.example.EmployeePayrollApp.entity.Employee;

import java.util.List;
/**
 *This is a interface for the methods of
 * service class.
 */
public interface IEmployeePayrollService {
    /**
     * This method is used to get all the data of the employees.
     *
     * @return List of Employees
     */
    List<Employee> getEmployeePayrollData();
    /**
     * This method is used to get all the data of the employees by using
     * a specific id.
     *
     * @param empId
     * @return ResponseEntity object of type ResponseDto
     */
    Employee getEmployeePayRollById(int empId);
    /**
     * This method is used to add the data of the employee.
     *
     * @return ResponseEntity object of type ResponseDto
     */
    Employee addEmployee(EmployeeDto employeePayrollDto);
    /**
     * This method is used to update the data of the employee by id.
     *
     * @param employeePayrollDto
     * @param empId
     * @return ResponseEntity object of type ResponseDto
     */
    Employee UpdateEmployeePayroll(int empId, EmployeeDto employeePayrollDto);
    /**
     * This method is used to delete the data of the employee by id.
     *
     * @param empid
     * @return ResponseEntity object of type ResponseDto
     */
    void deleteEmployeePayroll(int empid);
}
