package ru.job4j.oop;

public class Train implements Vehicle {

    @Override
    public void move() {
        System.out.println("Поезд мчит по рельсам");
    }

    @Override
    public void repare() {
        System.out.println(getClass().getSimpleName() + " ремонт");
    }
}
