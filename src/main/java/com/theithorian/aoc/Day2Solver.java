package com.theithorian.aoc;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Day2Solver implements Solver {

    @Autowired
    IDayInputService dayInputService;

    private static final long DAY_ID = 2;
    private static final int MAX_SAFE_DIFFERENCE = 3;
    private static final int MIN_SAFE_DIFFERENCE = 1;

    private enum Direction {
        Ascending,
        Descending,
        Neutral,
    }

    public long getId() {
        return DAY_ID;
    }

    public Solution<String> solveProblem() {
        var data = dayInputService.getInput(DAY_ID);

        var safeReports = getSafeReportsFromData(data.inputData());

        return new Solution<String>(String.valueOf(safeReports.size()), null);
    }

    private List<List<Integer>> getSafeReportsFromData(byte[] data) {
        var rawReports = new String(data).split("\n");

        var reports = Stream.of(rawReports)
                .map((report) -> rawReportToReport(report))
                .filter((report) -> isReportSafe(report))
                .collect(Collectors.toList());

        return reports;
    }

    private static List<Integer> rawReportToReport(String rawReport) {
        var rawReportArray = rawReport.split(" ");

        List<Integer> report = Stream.of(rawReportArray)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return report;
    }

    public Boolean isReportSafe(List<Integer> report) {
        Direction reportDirection = Direction.Neutral;

        for (int i = 1; i < report.size(); i++) {
            Integer lastValue = report.get(i - 1);
            Integer currValue = report.get(i);

            var difference = currValue - lastValue;

            Direction currDirection = getDirection(currValue, lastValue);

            if (i == 1)
                reportDirection = currDirection;

            if (currDirection.equals(Direction.Neutral) || !currDirection.equals(reportDirection))
                return false;

            if (Math.abs(difference) > MAX_SAFE_DIFFERENCE || Math.abs(difference) < MIN_SAFE_DIFFERENCE)
                return false;

        }

        return true;
    }

    private Direction getDirection(Integer a, Integer b) {
        if (a.equals(b))
            return Direction.Neutral;

        return b > a ? Direction.Ascending : Direction.Descending;
    }
}
