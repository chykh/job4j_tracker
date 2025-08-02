package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class JobLargeTest {

    @Test
    public void testSingleJIBN() {
        Job j1 = new Job("clean", 10);
        Job j2 = new Job("end work", 20);
        int result = new JobIncByName().compare(j1, j2);
        assertThat(result).isLessThan(0);
    }

    @Test
    public void testSingleJIBP() {
        Job j1 = new Job("clean", 10);
        Job j2 = new Job("end work", 20);
        int result = new JobIncByPriority().compare(j1, j2);
        assertThat(result).isLessThan(0);
    }

    @Test
    public void testSingleJDBN() {
        Job j1 = new Job("clean", 10);
        Job j2 = new Job("end work", 20);
        int result = new JobDescByName().compare(j1, j2);
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void testSingleJDBP() {
        Job j1 = new Job("clean", 10);
        Job j2 = new Job("end work", 20);
        int result = new JobDescByPriority().compare(j1, j2);
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void testComboJIBNJIBP() {
        Job j1 = new Job("clean", 30);
        Job j2 = new Job("clean", 20);
        int result = new JobIncByName().thenComparing(new JobDescByPriority()).compare(j1, j2);
        assertThat(result).isLessThan(0);
    }

    @Test
    public void testComboJDBNJIBP() {
        Job j1 = new Job("clean", 10);
        Job j2 = new Job("clean", 20);
        int result = new JobDescByName().thenComparing(new JobDescByPriority()).compare(j1, j2);
        assertThat(result).isGreaterThan(0);
    }

}