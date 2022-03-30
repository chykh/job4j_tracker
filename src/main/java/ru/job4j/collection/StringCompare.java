package ru.job4j.collection;

import java.util.Comparator;
public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int n = 0;

        for (int i = 0; i < Math.min(left.length(), right.length()); i++) {
            n = Character.compare(left.charAt(i), right.charAt(i));
            if (n != 0) {
                break;
            }
        }
        return n == 0 ? Integer.compare(left.length(), right.length()) : n;
    }
}