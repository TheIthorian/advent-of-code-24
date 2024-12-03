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
    SolutionWithTime<String> getSolutionForDay(@PathVariable long dayId) {
        var initialTime = System.nanoTime();

        var solver = solverFactory.getSolverForDay(dayId);
        var solution = solver.solveProblem().setExecutionTime((System.nanoTime() - initialTime) / 1_000_000);

        return solution;
    }

}
