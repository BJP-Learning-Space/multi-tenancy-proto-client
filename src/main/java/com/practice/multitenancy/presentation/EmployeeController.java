package com.practice.multitenancy.presentation;

import com.practice.multitenancy.application.EmployeeCommandService;
import com.practice.multitenancy.application.EmployeeQueryService;
import com.practice.multitenancy.domain.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeCommandService employeeCommandService;
    private final EmployeeQueryService employeeQueryService;

    public EmployeeController(final EmployeeCommandService employeeCommandService, final EmployeeQueryService employeeQueryService) {
        this.employeeCommandService = employeeCommandService;
        this.employeeQueryService = employeeQueryService;
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeCommandService.createEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") Long id) {
        return employeeQueryService.findById(id);
    }

    @GetMapping("/all")
    public Collection<Employee> getAll() {
        return employeeQueryService.findAll();
    }
}
