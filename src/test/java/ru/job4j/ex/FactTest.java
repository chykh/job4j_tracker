package ru.job4j.ex;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FactTest {

     @Test
    public void when5() {
        int expected = 120;
        int rsl = Fact.calc(5);
        assertThat(expected).isEqualTo(rsl);
    }
}