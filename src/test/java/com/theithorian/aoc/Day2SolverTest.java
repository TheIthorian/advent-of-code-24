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

    @Test
    public void solvesDay1ProblemWithInvalidEndValues() throws Exception {
        final String input = """
                4 3 2 1 7
                7 1 2 3 4""";

        var fakeInput = new DayInput(2L, input.getBytes());

        when(dayInputService.getInput(2L)).thenReturn(fakeInput);

        var solution = solver.solveProblem();

        assertEquals("0", solution.answer());
        assertEquals("2", solution.bonusAnswer());
    }

    @Test
    public void solvesDay1ProblemWithRepeatingValues() throws Exception {
        final String input = """
                4 4 4 4 4
                4 5 5 5 5
                4 5 5 5 4
                4 5 5 5 4
                5 5 4 5 5""";

        var fakeInput = new DayInput(2L, input.getBytes());

        when(dayInputService.getInput(2L)).thenReturn(fakeInput);

        var solution = solver.solveProblem();

        assertEquals("0", solution.answer());
        assertEquals("0", solution.bonusAnswer());
    }

    @Test
    public void solvesDay1ProblemWithMiscValues() throws Exception {
        final String input = """
                6 7 9 11 14
                71 68 67 64 61 58 57
                12 9 7 4 1
                12 12 9 7 4 1
                58 60 62 62 65 67 68
                67 68 70 72 74 77 79 79
                6 4 4 6 8 8
                69 71 69 66 63
                15 13 15 16 17 20 21 24""";

        var fakeInput = new DayInput(2L, input.getBytes());

        when(dayInputService.getInput(2L)).thenReturn(fakeInput);

        var solution = solver.solveProblem();

        assertEquals("3", solution.answer());
        assertEquals("8", solution.bonusAnswer());
    }

    @Test
    public void solvesDay1ProblemWithAdvancedEdgeCases() throws Exception {
        final String input = """
                7 10 8 10 11
                29 28 27 25 26 25 22 20""";

        var fakeInput = new DayInput(2L, input.getBytes());

        when(dayInputService.getInput(2L)).thenReturn(fakeInput);

        var solution = solver.solveProblem();

        assertEquals("0", solution.answer());
        assertEquals("2", solution.bonusAnswer());
    }

}
