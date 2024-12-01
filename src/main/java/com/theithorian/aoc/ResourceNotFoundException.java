package com.theithorian.aoc;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApplicationException {
    public ResourceNotFoundException(String message) {
        super(message);
        this.details = message;
        this.name = "ResourceNotFoundException";
        this.statusCode = HttpStatus.NOT_FOUND;
    }
}
