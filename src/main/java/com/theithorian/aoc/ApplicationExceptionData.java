package com.theithorian.aoc;

import org.springframework.http.HttpStatusCode;

public record ApplicationExceptionData(HttpStatusCode statusCode, String number) {
}
