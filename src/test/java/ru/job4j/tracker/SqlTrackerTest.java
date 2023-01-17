package ru.job4j.tracker;

import liquibase.pro.packaged.I;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static org.assertj.core.api.Assertions.*;

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
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenSameNameAndFindByNameThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        String name = "first";
        Item item = new Item(name);
        tracker.add(item);
        assertThat(tracker.findByName(name).contains(item));
    }

    @Test
    public void whenSameListAndFindAllThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = new Item("first");
        Item second = new Item("second");
        Item third = new Item("third");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        assertThat(tracker.findAll()).containsExactly(first, second, third);
    }

    @Test
    public void whenPartListAndDeletedFindAllThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = new Item("first");
        Item second = new Item("second");
        Item third = new Item("third");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        tracker.delete(second.getId());
        assertThat(tracker.findAll()).containsExactly(first, third);
    }

    @Test
    public void whenReplacedElementAndListThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = new Item("first");
        Item second = new Item("second");
        Item third = new Item("third");
        Item fourth = new Item("fourth");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        tracker.replace(second.getId(), fourth);
        assertThat(tracker.findAll()).containsExactly(first, fourth, third);
    }

    @Test
    public void whenAddedElementAndListThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = new Item("first");
        Item second = new Item("second");
        Item third = new Item("third");
        Item fourth = new Item("fourth");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        tracker.add(fourth);
        assertThat(tracker.findAll()).containsExactly(first, second, third, fourth);
    }
}