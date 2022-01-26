package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private boolean affraidBlood;

    public Surgeon(String name, String surname, String education, String birthday, boolean affraidBlood, Vodka vodka) {
        super(name, surname, education, birthday, true, vodka);
        this.affraidBlood = affraidBlood;
    }

    public boolean getAffraidBlood() {
        return this.affraidBlood;
    }
}
