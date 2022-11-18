package com.practice.multitenancy.application;

import com.practice.multitenancy.domain.Employee;
import com.practice.multitenancy.domain.EmployeeRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EmployeeQueryService {
    private final EmployeeRepository employeeRepository;

    public EmployeeQueryService(final EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee findById(final Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Collection<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
