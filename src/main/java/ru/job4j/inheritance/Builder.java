package ru.job4j.inheritance;

public class Builder extends Engineer {

    private boolean canWeld;
    private Frame frame;

    public Builder(String name, String surname, String education, String birthday, boolean canWeld, Frame frame) {
        super(name, surname, education, birthday, true);
        this.canWeld = canWeld;
        this.frame = frame;
    }

    public Frame getCanWeld(Frame frame) {
        return this.frame;
    }
}
