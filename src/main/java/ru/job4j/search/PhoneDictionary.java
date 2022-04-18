package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> checkName = p -> key.contains(p.getName());
        Predicate<Person> checkSurname = p -> key.contains(p.getSurname());
        Predicate<Person> checkPhone = p -> key.contains(p.getPhone());
        Predicate<Person> checkAddress = p -> key.contains(p.getAddress());
        Predicate<Person> combine = checkName.or(checkSurname).or(checkPhone).or(checkAddress);

        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }

}
