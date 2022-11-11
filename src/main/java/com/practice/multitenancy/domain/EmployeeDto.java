package com.practice.multitenancy.domain;


public class EmployeeDto {
    private final Long id;
    private final String name;

    public EmployeeDto(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
