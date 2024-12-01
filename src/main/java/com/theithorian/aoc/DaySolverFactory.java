package com.theithorian.aoc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class DaySolverFactory {

    @Autowired
    private List<Solver> solvers;

    private static Map<Long, Solver> solverCache = new HashMap<>();

    @PostConstruct
    public void initMyServiceCache() {
        for (Solver solver : solvers) {
            solverCache.put(solver.getId(), solver);
        }
    }

    public Solver getSolverForDay(long dayId) {
        Solver service = solverCache.get(dayId);

        if (service == null)
            throw new ResourceNotFoundException("Could not find solution for day: " + dayId);

        return service;
    }

}
