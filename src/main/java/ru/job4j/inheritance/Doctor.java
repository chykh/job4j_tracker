package ru.job4j.inheritance;

public class Doctor extends Profession {

    private boolean drinkALot;
    private Vodka vodka;

    public Doctor(String name, String surname, String education, String birthday, boolean drinkALot, Vodka vodka) {
        super(name, surname, education, birthday);
        this.drinkALot = drinkALot;
        this.vodka = vodka;
    }

    public Vodka getDrinkALot() {
        return this.vodka;
    }
}
