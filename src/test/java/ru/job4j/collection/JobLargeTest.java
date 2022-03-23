package ru.job4j.collection;

import org.junit.Test;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.lessThan;

public class JobLargeTest {

    @Test
    public void testSingleJIBN() {
        Job j1 = new Job("clean", 10);
        Job j2 = new Job("end work", 20);
        int result = new JobIncByName().compare(j1, j2);
        assertThat(result, lessThan(0));
    }

    @Test
    public void testSingleJIBP() {
        Job j1 = new Job("clean", 10);
        Job j2 = new Job("end work", 20);
        int result = new JobIncByPriority().compare(j1, j2);
        assertThat(result, lessThan(0));
    }

    @Test
    public void testSingleJDBN() {
        Job j1 = new Job("clean", 10);
        Job j2 = new Job("end work", 20);
        int result = new JobDescByName().compare(j1, j2);
        assertThat(result, greaterThan(0));
    }

    @Test
    public void testSingleJDBP() {
        Job j1 = new Job("clean", 10);
        Job j2 = new Job("end work", 20);
        int result = new JobDescByPriority().compare(j1, j2);
        assertThat(result, greaterThan(0));
    }

    @Test
    public void testComboJIBNJIBP() {
        Job j1 = new Job("clean", 10);
        Job j2 = new Job("end work", 20);
        int result = new JobIncByName().thenComparing(new JobDescByPriority()).compare(j1, j2);
        assertThat(result, lessThan(0));
    }

    @Test
    public void testComboJDBNJIBP() {
        Job j1 = new Job("clean", 10);
        Job j2 = new Job("end work", 20);
        int result = new JobDescByName().thenComparing(new JobDescByPriority()).compare(j1, j2);
        assertThat(result, greaterThan(0));
    }

}