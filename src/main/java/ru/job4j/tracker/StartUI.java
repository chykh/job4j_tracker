package ru.job4j.tracker;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        Item test = new Item();
        LocalDateTime lcd = test.getLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String lcdf = lcd.format(formatter);
        System.out.println("Текущие дата и время после форматирования: " + lcdf);
    }
}
