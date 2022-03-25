package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    String left;
    String right;

    @Override
    public int compare(String left, String right) {
        this.left = left;
        this.right = right;
        String[] first = left.split("\\.");
        String[] second = right.split("\\.");
        int one = Integer.parseInt(first[0]);
        int two = Integer.parseInt(second[0]);
        return Integer.compare(one, two);

    }

}