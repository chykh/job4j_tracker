package ru.job4j.collection;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.lessThan;

public class JobLargeTest extends TestCase {

    JobIncByName jIBN = new JobIncByName();
    JobIncByPriority jIBP = new JobIncByPriority();
    JobDescByName jDBN = new JobDescByName();
    JobDescByPriority jDBP = new JobDescByPriority();

    Job j1 = new Job("clean", 10);
    Job j2 = new Job("end work", 20);

    @Test
    public void testSingleJIBN() {
        int result = jIBN.compare(j1, j2);
        assertThat(result, lessThan(0));
    }

    @Test
    public void testSingleJIBP() {
        int result = jIBP.compare(j1, j2);
        assertThat(result, lessThan(0));
    }

    @Test
    public void testSingleJDBN() {
        int result = jDBN.compare(j1, j2);
        assertThat(result, greaterThan(0));
    }

    @Test
    public void testSingleJDBP() {
        int result = jDBP.compare(j1, j2);
        assertThat(result, greaterThan(0));
    }

    @Test
    public void testComboJIBNJIBP() {
        int result = jIBN.thenComparing(jDBP).compare(j1, j2);
        assertThat(result, lessThan(0));
    }

    @Test
    public void testComboJDBNJIBP() {
        int result = jDBN.thenComparing(jDBP).compare(j1, j2);
        assertThat(result, greaterThan(0));
    }
}

