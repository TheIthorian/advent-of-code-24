package com.theithorian.aoc;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {

    private ArrayUtils() {
    }

    public static <T> List<T> removeIndexFromList(List<T> list, int index) {
        List<T> filteredArray = new ArrayList<T>();

        for (int i = 0; i < list.size(); i++) {
            if (i != index)
                filteredArray.add(list.get(i));
        }

        return filteredArray;
    }

}
