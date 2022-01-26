package ru.job4j.inheritance;

public class Engineer extends Profession {

    private boolean canDraw;

    public Engineer(String name, String surname, String education, String birthday, boolean canDraw) {
        super(name, surname, education, birthday);
        this.canDraw = canDraw;
    }

    public boolean getCanDraw() {
        return this.canDraw;
    }

}
