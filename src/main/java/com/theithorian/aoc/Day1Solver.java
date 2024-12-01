package com.theithorian.aoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Day1Solver implements Solver {
    private static final long DAY_ID = 1;

    @Autowired
    IDayInputService dayInputService;

    private record ArrayData(List<Integer> arr1, List<Integer> arr2) {
    }

    @Override
    public long getId() {
        return DAY_ID;
    }

    @Override
    public Solution<String> solveProblem() {
        var dayInput = dayInputService.getInput(DAY_ID);

        var data = getArraysFromData(dayInput.inputData());

        var solution = sumDifference(data);

        return new Solution<String>(solution.toString());
    }

    private ArrayData getArraysFromData(byte[] inputData) {
        String input = new String(inputData);

        var arr1 = new ArrayList<Integer>();
        var arr2 = new ArrayList<Integer>();

        String[] lines = input.split("\n");
        for (String line : lines) {
            String nums[] = line.split("   ");

            arr1.add(Integer.parseInt(nums[0].trim()));
            arr2.add(Integer.parseInt(nums[1].trim()));
        }

        Collections.sort(arr1);
        Collections.sort(arr2);

        var arrayData = new ArrayData(arr1, arr2);

        return arrayData;
    }

    private Integer sumDifference(ArrayData data) {
        Integer sum = 0;

        for (int i = 0; i < data.arr1.size(); i++) {
            sum += Math.abs(data.arr1.get(i) - data.arr2.get(i));
        }

        return sum;
    }

}
