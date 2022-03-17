package ru.job4j.set;

import java.util.HashSet;
import java.util.Set;

public class Pangram {
    public static boolean checkString(String s) {
        char[] array = s.toCharArray();
        Set<Character> mass = new HashSet<>();
        for (char ch : array) {
            mass.add(ch);
        }
        int i = mass.size();
        return (i == 27);
    }
}
