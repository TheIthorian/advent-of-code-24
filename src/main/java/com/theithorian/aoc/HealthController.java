package com.theithorian.aoc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public HealthResult getHealth() {
        return new HealthResult("ok");
    }

}
