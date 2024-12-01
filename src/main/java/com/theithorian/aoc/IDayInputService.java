package com.theithorian.aoc;

public interface IDayInputService {
    public DayInput getInput(long dayId) throws ResourceNotFoundException;
}
