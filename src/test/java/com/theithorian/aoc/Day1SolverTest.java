package com.theithorian.aoc;

import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Day1SolverTest {

    @MockitoBean
    IDayInputService dayInputService;

    @Autowired
    Day1Solver solver;

    @Test
    public void solvesDay1Problem() throws Exception {
        final String input = """
                3   4
                4   3
                2   5
                1   3
                3   9
                3   3""";

        var fakeInput = new DayInput(1L, input.getBytes());

        when(dayInputService.getInput(1)).thenReturn(fakeInput);

        var solution = solver.solveProblem();

        assertEquals("11", solution.answer());
        assertEquals("31", solution.bonusAnswer());
    }

}
