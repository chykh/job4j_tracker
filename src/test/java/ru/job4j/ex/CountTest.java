package ru.job4j.ex;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CountTest {

    @Test()
    public void when0to2then3() {
        int rsl = Count.add(0, 3);
        assertThat(rsl).isEqualTo(3);
    }

}