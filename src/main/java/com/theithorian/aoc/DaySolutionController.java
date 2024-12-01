package com.theithorian.aoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DaySolutionController {

    @Autowired
    DaySolverFactory solverFactory;

    @GetMapping("api/day/{dayId}/solution")
    Solution<String> getInput(@PathVariable long dayId) {
        var solver = solverFactory.getSolverForDay(dayId);
        return solver.solveProblem();
    }

}
