package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int a) {
        return a - x;
    }

    public int divide(int a) {
        return a / x;
    }

    public int sumAllOperation(int a) {
        return sum(a) + multiply(a) + minus(a) + divide(a);
    }

    public static void main(String[] args) {
        int result = sum(10);
        System.out.println(result);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(10);
        System.out.println(rsl);
        System.out.println("Статич. разница: a = 100, x = 5, a - x = " + minus(100));
        int div = calculator.divide(50);
        System.out.println("Нестатич. деление: a = 50, x = 5, a / x = " + div);
        int sao = calculator.sumAllOperation(10);
        System.out.println("Нестатич. Сумма всего: a = 10, " + sao);
    }
}
