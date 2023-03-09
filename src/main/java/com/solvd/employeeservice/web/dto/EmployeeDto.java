package com.solvd.employeeservice.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class EmployeeDto {

    private Long id;

    @NotNull(message = "Email is required")
    @Length(min = 3, max = 45, message = "Email must be from 3 to 45 characters")
    private String email;

    @NotNull(message = "Name is required")
    @Length(min = 3, max = 45, message = "Name must be from 3 to 45 characters")
    private String name;

    @NotNull(message = "Surname is required")
    @Length(min = 3, max = 45, message = "Surname must be from 3 to 45 characters")
    private String surname;

    @NotNull(message = "Job title is required")
    @Length(min = 3, max = 45, message = "Job title must be from 3 to 45 characters")
    private String jobTitle;

    @NotNull(message = "Company is required")
    @Length(min = 3, max = 45, message = "Company must be from 3 to 45 characters")
    private String company;

}
