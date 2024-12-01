package com.theithorian.aoc;

import java.net.URI;

import org.springframework.http.HttpStatus;

public abstract class ApplicationException extends RuntimeException {
    protected HttpStatus statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
    protected String name = ApplicationException.class.getName();
    protected String details = "unknown";
    protected URI type = URI.create("about:blank");

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(Throwable cause) {
        super(cause);
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationExceptionData getData() {
        return new ApplicationExceptionData(statusCode, name);
    }

    public HttpStatus getStatusCode() {
        return this.statusCode;
    }

    public String getName() {
        return this.name;
    }

    public String getDetails() {
        return this.details;
    }

    public URI getType() {
        return this.type;
    }

}
