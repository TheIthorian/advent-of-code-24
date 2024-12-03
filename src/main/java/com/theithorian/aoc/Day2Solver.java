package com.theithorian.aoc;

import java.util.ArrayList;
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
    private static final int DAMPENER_COUNT = 1;

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

        var safeReports = getSafeReportsFromData(data.inputData(), 0);
        var safeReportsWithDampeners = getSafeReportsFromData(data.inputData(), DAMPENER_COUNT);

        return new Solution<String>(
                String.valueOf(safeReports.size()),
                String.valueOf(safeReportsWithDampeners.size()));
    }

    private List<List<Integer>> getSafeReportsFromData(byte[] data, int dampenerCount) {
        var rawReports = new String(data).split("\n");

        var reports = Stream.of(rawReports)
                .map((report) -> rawReportToReport(report))
                .filter((report) -> isReportSafe(report, dampenerCount))
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

    public Boolean isReportSafe(List<Integer> report, int dampenerCount) {
        Direction reportDirection = Direction.Neutral;

        for (int i = 1; i < report.size(); i++) {
            Integer lastValue = report.get(i - 1);
            Integer currValue = report.get(i);

            Direction currDirection = getDirection(lastValue, currValue);

            if (i == 1)
                reportDirection = currDirection;

            Boolean isSafe = isDifferenceSafe(reportDirection, currValue, lastValue);
            Boolean canUseDampener = dampenerCount > 0;

            if (!isSafe && canUseDampener)
                return isReportSafe(removeIndexFromList(report, i), dampenerCount - 1)
                        || isReportSafe(removeIndexFromList(report, 0), dampenerCount - 1)
                        || isReportSafe(removeIndexFromList(report, report.size() - 1), dampenerCount - 1);

            if (!isSafe)
                return false;
        }

        return true;
    }

    private Boolean isDifferenceSafe(Direction reportDirection, Integer currValue, Integer lastValue) {
        var difference = currValue - lastValue;

        Direction currDirection = getDirection(lastValue, currValue);

        if (currDirection.equals(Direction.Neutral) || !currDirection.equals(reportDirection))
            return false;

        if (Math.abs(difference) > MAX_SAFE_DIFFERENCE || Math.abs(difference) < MIN_SAFE_DIFFERENCE)
            return false;

        return true;
    }

    private static <T> List<T> removeIndexFromList(List<T> list, int index) {
        List<T> filteredArray = new ArrayList<T>();

        for (int i = 0; i < list.size(); i++) {
            if (i != index)
                filteredArray.add(list.get(i));
        }

        return filteredArray;
    }

    private Direction getDirection(Integer a, Integer b) {
        if (a.equals(b))
            return Direction.Neutral;

        return b > a ? Direction.Ascending : Direction.Descending;
    }
}
