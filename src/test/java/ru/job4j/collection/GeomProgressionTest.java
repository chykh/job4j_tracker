package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class GeomProgressionTest {
    @Test
    public void generateAndSum() {
        int rsl = GeomProgression.generateAndSum(1, 3, 10);
        assertThat(rsl).isEqualTo(29524);
    }

    @Test
    public void generateAndSumIs0() {
        int rsl = GeomProgression.generateAndSum(1, -1, 10);
        assertThat(rsl).isEqualTo(0);
    }
}