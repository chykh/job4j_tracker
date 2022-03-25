package ru.job4j.collection;

import java.util.Comparator;
public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int n = 0;
        int size = left.length() < right.length() ? left.length() : right.length();

        for (int i = 0; i < size; i++) {
            n = Character.compare(left.charAt(i), right.charAt(i));
            if (n != 0) {
                break;
            }
            if (i == size - 1) {
                n = Integer.compare(left.length(), right.length());
            }
        }
        return n;
    }
}