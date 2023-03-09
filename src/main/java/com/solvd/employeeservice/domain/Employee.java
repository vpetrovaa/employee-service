package com.solvd.employeeservice.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employees")
@Data
public class Employee {

    @Id
    private Long id;

    private String email;

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String surname;

    @Column(name = "job_title")
    private String jobTitle;

    private String company;

}
