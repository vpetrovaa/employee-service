package com.solvd.employeeservice.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
@Data
public class Employee {

    @Transient
    public static final String SEQUENCE_NAME = "employees_sequence";

    @Id
    private Long id;

    private String email;

    private String name;

    private String surname;

    private String jobTitle;

    private String company;

}
