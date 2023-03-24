package com.solvd.employeeservice.service;

import com.solvd.employeeservice.domain.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {

    Mono<Employee> findById(String id);

    Mono<Employee> create(Employee employee);

    Flux<Employee> findAll();

    Flux<Employee> findAllByCompany(String company);

}
