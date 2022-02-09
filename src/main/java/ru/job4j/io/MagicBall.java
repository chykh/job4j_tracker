package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {

    static private String[] answers = new String[] {"Да", "Нет", "Наверное"};

    public static void main(String[] args) {
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        int random = new Random().nextInt(3);
        System.out.println("Вот мой ответ: " + answers[random]);
    }
}
