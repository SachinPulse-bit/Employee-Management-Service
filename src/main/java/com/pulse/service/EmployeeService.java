package com.pulse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.pulse.repository.Employee;
import com.pulse.repository.EmployeeRepository;
import com.pulse.repository.EmployeeSpecification;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));

        employee.setName(employeeDetails.getName());
        employee.setSalary(employeeDetails.getSalary());
        employee.setDepartment(employeeDetails.getDepartment());
        employee.setExperience(employeeDetails.getExperience());

        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
    
    public Page<Employee> searchEmployees(String name, String department, int page, int size) {
        
    	Pageable pageable = PageRequest.of(page, size);

        // Combine specifications (search by name and/or department)
        Specification<Employee> spec = Specification.where(EmployeeSpecification.searchByName(name))
                                                    .and(EmployeeSpecification.searchByDepartment(department));

        return employeeRepository.findAll(spec, pageable); // Fetch the results with pagination
    }
}

