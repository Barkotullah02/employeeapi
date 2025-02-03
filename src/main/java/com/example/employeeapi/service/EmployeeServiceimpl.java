package com.example.employeeapi.service;

import com.example.employeeapi.Employee;
import com.example.employeeapi.dao.EmployeeDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceimpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceimpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }


    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }


    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }


    @Transactional
    @Override
    public void delete(int id) {
        employeeDAO.delete(id);

    }
}
