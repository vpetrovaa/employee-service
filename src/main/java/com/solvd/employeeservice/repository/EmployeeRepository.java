package com.solvd.employeeservice.repository;

import com.solvd.employeeservice.domain.Employee;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface EmployeeRepository extends R2dbcRepository<Employee, Long> {

    Mono<Boolean> existsByEmail(String email);

}
