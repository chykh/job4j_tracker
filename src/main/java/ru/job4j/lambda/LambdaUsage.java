package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("eeee", "a", "ccc", "bb");
        System.out.println("исходный массив");
        for (String str : strings) {
            System.out.print(str + "  ");
        }
        System.out.println();

        Comparator<String> comparator = (left, right) -> {
            System.out.println("сравниваем: " + left + " и " + right);
            return Integer.compare(right.length(), left.length());
        };

        strings.sort(comparator);
        System.out.println("отсортированный по уменьшению длины массив");
        for (String str : strings) {
            System.out.print(str + "  ");
        }
    }
}
