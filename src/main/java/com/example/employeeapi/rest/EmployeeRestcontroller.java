package com.example.employeeapi.rest;


import com.example.employeeapi.Employee;
import com.example.employeeapi.dao.EmployeeDAO;
import com.example.employeeapi.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return employeeService.findById(empId);
    }
}
