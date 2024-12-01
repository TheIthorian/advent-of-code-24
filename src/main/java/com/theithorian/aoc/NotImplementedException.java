package com.theithorian.aoc;

import org.springframework.http.HttpStatus;

public class NotImplementedException extends ApplicationException {
    public NotImplementedException(String message) {
        super(message);
        this.details = "Service not implemented";
        this.name = "NotImplementedException";
        this.statusCode = HttpStatus.NOT_IMPLEMENTED;
    }
}
