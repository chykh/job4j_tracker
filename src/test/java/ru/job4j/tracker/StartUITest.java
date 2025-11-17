package ru.job4j.tracker;

import java.util.List;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "Item name", "1"});
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = List.of(new CreateAction(out), new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        String replacedName = "New item name";
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Replaced item"));
        Input in = new StubInput(new String[]{"0", String.valueOf(item.getId()), replacedName, "1"});
        List<UserAction> actions = List.of(new ReplaceAction(out), new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0"});
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = List.of(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString()).isEqualTo("Menu:" + System.lineSeparator()
                + "0. ExitAction" + System.lineSeparator());
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(new String[] {"0",
                String.valueOf(one.getId()), replaceName, "1"});
        List<UserAction> actions = List.of(new ReplaceAction(out), new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. ExitAction" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. ExitAction" + ln
        );
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Input in = new StubInput(new String[] {"5", "0"});
        List<UserAction> actions = List.of(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("Menu:" + ln
                + "0. ExitAction" + ln
                + "Wrong input, you can select: 0 .. 0" + ln
                + "Menu:" + ln
                + "0. ExitAction" + ln);
    }

    @Test
    public void whenFindbyId() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("test"));
        List<UserAction> actions = List.of(new FindByIdAction(out), new ExitAction());
        Input in = new StubInput(new String[]{"0", String.valueOf(item.getId()), "1"});
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("Menu:" + ln
                           + "0. Find item by id" + ln
                           + "1. ExitAction" + ln
                           + "=== Find item by id ===" + ln
                           + item + ln
                           + "Menu:" + ln
                           + "0. Find item by id" + ln
                           + "1. ExitAction" + ln);
    }

    @Test
    public void whenFindbyName() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("test"));
        List<UserAction> actions = List.of(new FindByNameAction(out), new ExitAction());
        Input in = new StubInput(new String[]{"0", String.valueOf(item.getName()), "1"});
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("Menu:" + ln
                + "0. Find items by name" + ln
                + "1. ExitAction" + ln
                + "=== Find items by name ===" + ln
                + item + ln
                + "Menu:" + ln
                + "0. Find items by name" + ln
                + "1. ExitAction" + ln);
    }

    @Test
    public void whenFindbyAllItems() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("test"));
        Item item2 = tracker.add(new Item("test2"));
        List<UserAction> actions = List.of(new ShowItemAction(out), new ExitAction());
        Input in = new StubInput(new String[]{"0", "1"});
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("Menu:" + ln
                + "0. Show all items" + ln
                + "1. ExitAction" + ln
                + "=== Show all items ===" + ln
                + item + ln
                + item2 + ln
                + "Menu:" + ln
                + "0. Show all items" + ln
                + "1. ExitAction" + ln);
    }

}