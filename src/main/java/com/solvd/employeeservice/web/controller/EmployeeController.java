package com.solvd.employeeservice.web.controller;

import com.solvd.employeeservice.domain.Employee;
import com.solvd.employeeservice.service.EmployeeService;
import com.solvd.employeeservice.web.dto.EmployeeDto;
import com.solvd.employeeservice.web.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @PostMapping
    public Mono<EmployeeDto> create(@RequestBody @Validated EmployeeDto employeeDto) {
        Employee employeeMapped = employeeMapper.toEntity(employeeDto);
        Mono<Employee> employee = employeeService.create(employeeMapped);
        return employee.map(employeeMapper::toDto);
    }

    @GetMapping
    public Flux<EmployeeDto> findAll() {
        Flux<Employee> employees = employeeService.findAll();
        return employees.map(employeeMapper::toDto);
    }

    @GetMapping("/{id}")
    public Mono<EmployeeDto> findById(@PathVariable String id) {
        Mono<Employee> employee = employeeService.findById(id);
        return employee.map(employeeMapper::toDto);
    }

    @GetMapping("/company/{company}")
    public Flux<EmployeeDto> findByCompanyId(@PathVariable String company) {
        Flux<Employee> employees = employeeService.findAllByCompany(company);
        return employees.map(employeeMapper::toDto);
    }

}
