package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {

    static private String[] otveti = new String[] {"Да", "Нет", "Наверное"};

    public static void main(String[] args) {
        System.out.println("Я великий Оракул. Что ты хочешь узнать? ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        System.out.println("Твой вопрос - " + name + "!!");
        int answer = new Random().nextInt(3);
        System.out.println("Вот мой ответ: " + otveti[answer]);

    }
}
