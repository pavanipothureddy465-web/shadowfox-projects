package com.shadowfox.employeeleavemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shadowfox.employeeleavemanagement.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
