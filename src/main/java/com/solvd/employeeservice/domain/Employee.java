package com.solvd.employeeservice.domain;

import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name = "employee")
@Data
public class Employee {

    @Id
    private Long id;

    private String email;

    private String name;

    private String surname;

    private String jobTitle;

    private String company;

}
