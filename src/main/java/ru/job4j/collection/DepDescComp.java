package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    public int compare(String s1, String s2) {
        int res = s1.compareTo(s2);

        String[] str1 = s1.split("/");
        String[] str2 = s2.split("/");
        int result = str1[0].compareTo(str2[0]);
        if (result != 0) {
            return result > 0 ? -1 : 1;
        } else {
            return res;
        }
    }
}
