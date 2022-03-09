package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionUsage {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("one");
        collection.add("two");
        collection.add("three");
        System.out.println("размер " + collection.size());
        System.out.println("содержит two " + collection.contains("two"));
        System.out.println("в виде массива " + Arrays.toString(collection.toArray()));
        collection.clear();
        System.out.println("Пуста " + collection.isEmpty());
    }
}
