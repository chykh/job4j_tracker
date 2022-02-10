package ru.job4j.poly;

public class Bus implements Transport {
    private int amount = 10;
    private boolean voyage = false;
    private double money;
    private int ticket = 100;

    @Override
    public void drive() {
        voyage = true;
    }

    @Override
    public void passengers(int passenger) {
        money = passenger * ticket;
    }

    @Override
    public double price(int fuel) {
        return fuel * amount;
    }
}
