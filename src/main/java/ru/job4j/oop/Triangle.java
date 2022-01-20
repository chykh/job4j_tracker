package ru.job4j.oop;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    public double semiPerimeter(double a, double b, double c) {
        return (a + b + c) / 2;

    }

    public boolean exist(double ab, double ac, double bc) {
        return (ab + ac > bc) && (ab + bc > ac) && (bc + ac > ab);
    }

    public double area() {
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        double s = -1;

        if (this.exist(ab, ac, bc)) {
            double p = semiPerimeter(ab, ac, bc);
            s = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return s;
    }

    public static void main(String[] args) {
        Point a = new Point(0, 0);
        Point b = new Point(0, 3);
        Point c = new Point(3, 0);

        Triangle tr = new Triangle(a, b, c);
        System.out.println(tr.area());
    }
}
