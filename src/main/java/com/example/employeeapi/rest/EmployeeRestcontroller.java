package com.example.employeeapi.rest;


import com.example.employeeapi.Employee;
import com.example.employeeapi.dao.EmployeeDAO;
import com.example.employeeapi.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestcontroller {
    private EmployeeService employeeService;

    public EmployeeRestcontroller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{empId}")
    Employee getEmployee(@PathVariable int empId) {
        Employee employee = employeeService.findById(empId);
        if (employee == null) {
            throw new RuntimeException("Employee with id " + empId + " not found");
        }
        return employee;
    }
    @PostMapping("/employees")
    Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        Employee savedEmployee = employeeService.save(employee);
        return savedEmployee;
    }
    @PutMapping("/employees/{employeeid}")
    Employee updateEmployee(@RequestBody Employee employee, @PathVariable int employeeid) {
        employee.setId(employeeid);
        Employee savedEmployee = employeeService.save(employee);
        return savedEmployee;
    }

    @DeleteMapping("/employees/{employeeid}")
    String deleteEmployee(@PathVariable int employeeid) {
        Employee employee = employeeService.findById(employeeid);
        if (employee == null){
            return "Employee id not found";
        }
        employeeService.delete(employeeid);
        return "Deleted employee with id " + employeeid;
    }
}
