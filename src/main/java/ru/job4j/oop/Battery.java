package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public int getLoad() {
        return load;
    }

    public void exchange(Battery another) {
        another.load = another.load + this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery phone = new Battery(10);
        System.out.println("phone " + phone.getLoad());
        Battery powerbank = new Battery(100);
        System.out.println("powerbank " + powerbank.getLoad());
        powerbank.exchange(phone);
        System.out.println("phone " + phone.getLoad());
        System.out.println("powerbank " + powerbank.getLoad());
    }
}
