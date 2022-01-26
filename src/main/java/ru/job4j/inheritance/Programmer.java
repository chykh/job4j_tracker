package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private boolean knowJawa;

    public Programmer(String name, String surname, String education, String birthday, boolean knowJawa) {
        super(name, surname, education, birthday, false);
        this.knowJawa = knowJawa;
    }

    public boolean getKnowJawa() {
        return this.knowJawa;
    }
}
