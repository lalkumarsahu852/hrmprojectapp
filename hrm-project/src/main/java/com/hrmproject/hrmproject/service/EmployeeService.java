package com.hrmproject.hrmproject.service;

import com.hrmproject.hrmproject.entity.Employee;
import com.hrmproject.hrmproject.payload.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    List<Employee> getEmployeesByDepartment(String department);
    void saveEmployee(Employee employee);
    void deleteEmployee(Long id);
    EmployeeDTO updateEmployee(Long id, EmployeeDTO updatedEmployee);
}

