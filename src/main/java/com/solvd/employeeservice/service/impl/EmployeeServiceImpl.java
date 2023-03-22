package com.solvd.employeeservice.service.impl;

import com.solvd.employeeservice.domain.Employee;
import com.solvd.employeeservice.domain.exception.ResourceAlreadyExistsException;
import com.solvd.employeeservice.repository.EmployeeRepository;
import com.solvd.employeeservice.service.EmployeeService;
import com.solvd.employeeservice.web.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public Mono<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Mono<Employee> create(Employee employee) {
        return employeeRepository.existsByEmail(employee.getEmail())
                .flatMap(isExist -> {
                    if (isExist) {
                        return Mono.error(new ResourceAlreadyExistsException("Employee with email " + employee.getEmail() + " already exists"));
                    }
                    return employeeRepository.save(employee);
                });
    }

    @Override
    public Flux<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Flux<Employee> findAllByCompany(String company) {
        return employeeRepository.findAllByCompany(company);
    }

}
