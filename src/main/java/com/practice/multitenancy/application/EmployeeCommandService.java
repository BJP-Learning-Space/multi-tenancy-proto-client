package com.practice.multitenancy.application;

import com.practice.multitenancy.domain.Employee;
import com.practice.multitenancy.domain.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeCommandService {
    private final EmployeeRepository employeeRepository;

    public EmployeeCommandService(final EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(final Employee employee) {
        return employeeRepository.save(employee);
    }
}
