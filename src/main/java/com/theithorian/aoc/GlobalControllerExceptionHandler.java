package com.theithorian.aoc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

    @ExceptionHandler({ ApplicationException.class })
    public ErrorResponse handleApplicationException(ApplicationException ex, WebRequest request) {
        logger.warn(String.format("%s : %s", ex.name, ex.details));

        var problemDetail = ProblemDetail.forStatusAndDetail(ex.getStatusCode(), ex.getDetails());
        problemDetail.setType(ex.getType());

        return ErrorResponse.builder(ex, problemDetail).build();
    }

    @ExceptionHandler(Exception.class)
    public ErrorResponse handleGlobalException(Exception ex, WebRequest request) {
        logger.warn(ApplicationException.class.getName(), ex);

        var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());

        return ErrorResponse.builder(ex, problemDetail).build();
    }
}
