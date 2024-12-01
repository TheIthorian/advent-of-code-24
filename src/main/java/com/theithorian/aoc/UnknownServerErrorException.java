package com.theithorian.aoc;

public class UnknownServerErrorException extends ApplicationException {
    public Number statusCode = 500;
    public String name = "UNKNOWN_SERVER_ERROR";

    public UnknownServerErrorException(String message) {
        super(message);
    }
}
