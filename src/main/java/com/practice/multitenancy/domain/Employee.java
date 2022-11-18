package com.practice.multitenancy.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Employee(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public Employee() {}

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
