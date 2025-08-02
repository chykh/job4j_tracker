package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ItemSortTest {

    @Test
    public void testCompare() {
            List<Item> items = Arrays.asList(new Item("C - first"),
                    new Item("A - second"), new Item("B - third"));

            List<Item> expected = Arrays.asList(new Item("A - second"),
                    new Item("B - third"), new Item("C - first"));
            Collections.sort(items, new ItemAscByName());
            assertThat(items).isEqualTo(expected);
    }

    @Test
    public void testReverseCompare() {
        List<Item> items = Arrays.asList(new Item("C - first"),
                new Item("A - second"), new Item("B - third"));

        List<Item> expected = Arrays.asList(new Item("C - first"),
                new Item("B - third"), new Item("A - second"));
        Collections.sort(items, new ItemDescByName());
        assertThat(items).isEqualTo(expected);
    }
}