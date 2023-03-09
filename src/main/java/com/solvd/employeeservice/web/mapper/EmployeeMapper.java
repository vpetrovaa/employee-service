package com.solvd.employeeservice.web.mapper;

import com.solvd.employeeservice.domain.Employee;
import com.solvd.employeeservice.web.dto.EmployeeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee toEntity(EmployeeDto employeeDto);

    EmployeeDto toDto(Employee employee);

}
