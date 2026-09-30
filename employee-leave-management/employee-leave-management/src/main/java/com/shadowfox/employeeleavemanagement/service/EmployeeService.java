package com.shadowfox.employeeleavemanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shadowfox.employeeleavemanagement.entity.Employee;
import com.shadowfox.employeeleavemanagement.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
}