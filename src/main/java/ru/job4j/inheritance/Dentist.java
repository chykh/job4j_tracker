package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private int teethLeft;
    private Vodka vodka;

    public Dentist(String name, String surname, String education, String birthday, int teethLeft, Vodka vodka) {
        super(name, surname, education, birthday, false, vodka);
        this.teethLeft = teethLeft;
    }

    public int getTeethLeft() {
        return teethLeft;
    }
}
