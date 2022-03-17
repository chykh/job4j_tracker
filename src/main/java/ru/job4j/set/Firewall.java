package ru.job4j.set;

import java.util.HashSet;
import java.util.Set;

public class Firewall {
    public static String checkName(String s, Set<String> words) {
        String[] array = s.split(" ");
        Set<String> name = new HashSet<>();
        for (String str : array) {
            name.add(str);
        }
        for (String str : words) {
            if (name.add(str)) {
                return "Выберите другую статью...";
            }
        }
        return "Вы сделали правильный выбор!";
    }
}