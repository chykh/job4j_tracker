package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = new FileInputStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSameItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenSameNameAndFindByNameThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        String name = "first";
        Item item = tracker.add(new Item(name));
        assertThat(tracker.findByName(name)).contains(item);
    }

    @Test
    public void whenSameListAndFindAllThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = tracker.add(new Item("first"));
        Item second = tracker.add(new Item("second"));
        Item third = tracker.add(new Item("third"));
        assertThat(tracker.findAll()).containsExactly(first, second, third);
    }

    @Test
    public void whenPartListAndDeletedFindAllThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = tracker.add(new Item("first"));
        Item second = tracker.add(new Item("second"));
        int id = second.getId();
        Item third = tracker.add(new Item("third"));
        tracker.delete(second.getId());
        assertThat(tracker.findAll()).containsExactly(first, third);
        assertThat(tracker.findById(id)).isNull();
    }

    @Test
    public void whenReplacedElementAndListThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = tracker.add(new Item("first"));
        Item second = tracker.add(new Item("second"));
        Item third = tracker.add(new Item("third"));
        Item fourth = new Item("fourth");
        int id = second.getId();
        tracker.replace(second.getId(), fourth);
        assertThat(tracker.findAll()).containsExactly(first, fourth, third);
        assertThat(tracker.findById(id).getName()).isEqualTo("fourth");

    }

    @Test
    public void whenAddedElementAndListThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = tracker.add(new Item("first"));
        Item second = tracker.add(new Item("second"));
        Item third = tracker.add(new Item("third"));
        Item fourth = tracker.add(new Item("fourth"));
        assertThat(tracker.findAll()).containsExactly(first, second, third, fourth);
    }
}