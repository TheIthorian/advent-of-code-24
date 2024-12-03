package com.theithorian.aoc;

import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Day2SolverTest {

    @MockitoBean
    IDayInputService dayInputService;

    @Autowired
    Day2Solver solver;

    @Test
    public void solvesDay1Problem() throws Exception {
        final String input = """
                7 6 4 2 1
                1 2 7 8 9
                9 7 6 2 1
                1 3 2 4 5
                8 6 4 4 1
                1 3 6 7 9""";

        var fakeInput = new DayInput(2L, input.getBytes());

        when(dayInputService.getInput(2L)).thenReturn(fakeInput);

        var solution = solver.solveProblem();

        assertEquals("2", solution.answer());
        assertEquals("4", solution.bonusAnswer());
    }

}
