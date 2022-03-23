package ru.job4j.tracker;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ItemSortTest {

    @Test
    public void testCompare() {
            List<Item> items = Arrays.asList(new Item("C - first"),
                    new Item("A - second"), new Item("B - third"));

            List<Item> expected = Arrays.asList(new Item("A - second"),
                    new Item("B - third"), new Item("C - first"));
            Collections.sort(items, new ItemAscByName());
            assertEquals(items, expected);

    }

    @Test
    public void testReverseCompare() {
        List<Item> items = Arrays.asList(new Item("C - first"),
                new Item("A - second"), new Item("B - third"));

        List<Item> expected = Arrays.asList(new Item("C - first"),
                new Item("B - third"), new Item("A - second"));
        Collections.sort(items, new ItemDescByName());
        assertEquals(items, expected);

    }
}