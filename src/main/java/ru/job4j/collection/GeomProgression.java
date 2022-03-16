package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class GeomProgression {
    public static int generateAndSum(int first, int denominator, int count) {
        List<Integer> list = new ArrayList<>();
        int res = 0;
        for (int i = 1; i <= count; i++) {
            int number = (int) (first * Math.pow(denominator, i - 1));
            list.add(res);
            res += number;
        }

        return res;
    }
}
