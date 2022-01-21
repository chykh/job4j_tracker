package ru.job4j.oop;

import static org.hamcrest.Matchers.closeTo;
import junit.framework.TestCase;
import static org.junit.Assert.assertThat;

public class PointTest extends TestCase {

    public void testDistance() {
        Point first = new Point(0, 0);
        Point second = new Point(1, 1);
        double result = first.distance(second);
        double expected = 1.41;
        assertThat(expected, closeTo(result, 0.1));
    }

    public void testDistance2() {
        Point first = new Point(0, 0);
        Point second = new Point(5, 5);
        double result = first.distance(second);
        double expected = 7.07;
        assertThat(expected, closeTo(result, 0.1));
    }

    public void testDistance3d() {
        Point first = new Point(0, 0, 0);
        Point second = new Point(1, 1, 1);
        double result = first.distance3d(second);
        double expected = 1.73;
        assertThat(expected, closeTo(result, 0.1));
    }

    public void testDistance3d2() {
        Point first = new Point(0, 0, 0);
        Point second = new Point(5, 5,  5);
        double result = first.distance3d(second);
        double expected = 8.65;
        assertThat(expected, closeTo(result, 0.1));
    }
}