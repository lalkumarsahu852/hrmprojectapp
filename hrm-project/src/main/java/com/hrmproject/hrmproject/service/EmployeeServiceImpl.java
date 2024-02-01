package com.hrmproject.hrmproject.service;

import com.hrmproject.hrmproject.entity.Employee;
import com.hrmproject.hrmproject.payload.EmployeeDTO;
import com.hrmproject.hrmproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO updatedEmployee) {
        // Check if the employee with the given ID exists
        if (employeeRepository.existsById(id)) {
            // Set the ID of the updated employee to match the ID in the path
            updatedEmployee.setId(id);
            // Save the updated employee data
            Employee updatedEntity = convertToEntity(updatedEmployee);
            employeeRepository.save(updatedEntity);
            return updatedEmployee;
        } else {
            return null; // Employee with the given ID not found
        }
    }
    private Employee convertToEntity(EmployeeDTO employeeDTO) {
        // Implement the conversion logic from DTO to entity here

        if (employeeDTO == null) {
            return null;
        }

        Employee employee = new Employee();
        employee.setEmpId(employeeDTO.getId());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
        employee.setEmail(employeeDTO.getEmail());
        employee.setDepartment(employeeDTO.getDepartment());

        return employee;
    }
}

