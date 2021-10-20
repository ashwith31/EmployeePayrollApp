package com.example.EmployeePayrollApp.controller;

import com.example.EmployeePayrollApp.dto.EmployeeDto;
import com.example.EmployeePayrollApp.dto.ResponseDto;
import com.example.EmployeePayrollApp.entity.Employee;
import com.example.EmployeePayrollApp.service.EmployeePayrollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 *This is a controller class.It handles all the part of http calls.
 */
@Slf4j
@RestController
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeeService;

    /**
     * This method is used to get all the data of the employees.
     *
     * @return ResponseEntity object of type ResponseDto
     */
    @GetMapping("/get")
    public ResponseEntity<ResponseDto> getEmployeePayrollData() {
        List<Employee> employeePayRollData = null;
        employeePayRollData = employeeService.getEmployeePayrollData();
        ResponseDto responseDto = new ResponseDto("Get Call Success", employeePayRollData);
        log.info("got all the data of the employee");
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
    /**
     * This method is used to get all the data of the employees by using
     * a specific id.
     *
     * @param empId
     * @return ResponseEntity object of type ResponseDto
     */

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDto> getEmployeePayrollDataById(@PathVariable(value = "empId") int empId) {
        Employee employeePayRollData = null;
        employeePayRollData = employeeService.getEmployeePayRollById(empId);
        ResponseDto responseDto = new ResponseDto("Get Call Success For Id", employeePayRollData);
        log.info("Get Call Success For Id");
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
    /**
     * This method is used to add the data of the employee.
     *
     * @return ResponseEntity object of type ResponseDto
     */

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> addEmployeePayrollData(@Valid @RequestBody EmployeeDto employeePayrollDto) {
        Employee employeePayRollData = null;
        employeePayRollData = employeeService.addEmployee(employeePayrollDto);
        ResponseDto responseDto = new ResponseDto("Created Employee Payroll Data For ", employeePayRollData);
        log.info("Created Employee Payroll Data");
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
    /**
     * This method is used to update the data of the employee by id.
     *
     * @param employeePayrollDto
     * @param empId
     * @return ResponseEntity object of type ResponseDto
     */

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDto> updateEmployeePayroll(@PathVariable(value = "empId") int empId, @Valid @RequestBody EmployeeDto employeePayrollDto) {
        Employee employeePayRollData = null;
        employeePayRollData = employeeService.UpdateEmployeePayroll(empId, employeePayrollDto);
        ResponseDto responseDto = new ResponseDto("Update Employee Payroll Data For ", employeePayRollData);
        log.info("Update Employee Payroll Data");
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
    /**
     * This method is used to delete the data of the employee by id.
     *
     * @param empId
     * @return ResponseEntity object of type ResponseDto
     */

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDto> deleteEmployeePayroll(@PathVariable(value = "empId") int empId) {
        employeeService.deleteEmployeePayroll(empId);
        ResponseDto responseDto = new ResponseDto("Deleted Successfully", "deleted id: " + empId);
        log.info("Deleted Successfully");
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
}
