package com.solvd.employeeservice.domain.exception;

public class ResourceAlreadyExistsException extends RuntimeException{

    public ResourceAlreadyExistsException(String message) {
        super(message);
    }

}
