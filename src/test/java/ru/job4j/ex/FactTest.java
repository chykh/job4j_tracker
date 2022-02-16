package ru.job4j.ex;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenNMinus5() {
        Fact.calc(-5);
    }

    @Test
    public void when5() {
        int expected = 120;
        int rsl = Fact.calc(5);
        assertThat(expected, is(rsl));
    }
}