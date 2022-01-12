package ru.job4j.oop;

public class Student {

    public void music(String lyrics) {

        System.out.println(lyrics);
    }

    public static void main(String[] args) {
        Student petya = new Student();
        petya.music("tra-ta-ta");
    }
}
