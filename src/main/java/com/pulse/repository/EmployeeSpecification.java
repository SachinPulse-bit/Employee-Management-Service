package com.pulse.repository;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class EmployeeSpecification {

    // Search by name (case-insensitive partial match)
    public static Specification<Employee> searchByName(String name) {
        return (Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            if (name == null || name.isEmpty()) {
                return cb.conjunction(); // Return no condition if name is not provided
            }
            return cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
        };
    }

    // Search by department (exact match, case-insensitive)
    public static Specification<Employee> searchByDepartment(String department) {
        return (Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            if (department == null || department.isEmpty()) {
                return cb.conjunction(); // Return no condition if department is not provided
            }
            return cb.equal(cb.lower(root.get("department")), department.toLowerCase());
        };
    }
}
