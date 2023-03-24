package com.solvd.employeeservice.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeDto {

    private String id;

    @NotNull(message = "Email is required")
    private String email;

    @NotNull(message = "Name is required")
    private String name;

    @NotNull(message = "Surname is required")
    private String surname;

    @NotNull(message = "Job title is required")
    private String jobTitle;

    @NotNull(message = "Company is required")
    private String company;

}
