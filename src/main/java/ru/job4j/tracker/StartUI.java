package ru.job4j.tracker;

public class StartUI {

    public static void main(String[] args) {
        Item test = new Item(14, "заявка");
        System.out.println(test);

        System.out.println(test.getLocalDateTime());
    }
}
