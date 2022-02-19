package ru.job4j.ex;

public abstract class ShapeOperator {
    public void showInfo() {
        Shape shape = createShape();
        System.out.println(shape.draw());
        System.out.println("Площадь фигуры " + shape.square());
    }

    public abstract Shape createShape();
}
