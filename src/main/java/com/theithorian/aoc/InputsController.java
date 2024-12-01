package com.theithorian.aoc;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InputsController {
    @Autowired
    IDayInputService dayInputService;

    @GetMapping("api/day/{dayId}/input")
    ResponseEntity<byte[]> getInput(@PathVariable Long dayId) {
        try {
            var dayInput = dayInputService.getInput(dayId);
            var response = ResponseEntity
                    .ok()
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(dayInput.inputData());

            return response;
        } catch (Exception ex) {
            throw new ResourceNotFoundException(String.format("Input for day %s not found", dayId));
        }
    }

}
