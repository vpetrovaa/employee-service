package com.solvd.employeeservice.repository;

import com.solvd.employeeservice.domain.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, Long> {

    Mono<Boolean> existsByEmail(String email);

    Flux<Employee> findAllByCompany(String company);

}
