package com.theithorian.aoc;

public record Solution<T>(T answer, T bonusAnswer) {

    public SolutionWithTime<T> setExecutionTime(long time) {
        return new SolutionWithTime<T>(answer, bonusAnswer, time);
    }

}
