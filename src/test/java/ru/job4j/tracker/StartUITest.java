package ru.job4j.tracker;

import org.junit.Test;


import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.nullValue;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "Item name", "1"});
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = List.of(new CreateAction(out), new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        String replacedName = "New item name";
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Replaced item"));
        Input in = new StubInput(new String[]{"0", String.valueOf(item.getId()), replacedName, "1"});
        List<UserAction> actions = List.of(new ReplaceAction(out), new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(new String[]{"0", String.valueOf(item.getId()), "1"});
        List<UserAction> actions = List.of(new DeleteAction(out), new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0"});
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = List.of(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu:" + System.lineSeparator()
                + "0. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(new String[] {"0",
                String.valueOf(one.getId()), replaceName, "1"});
        List<UserAction> actions = List.of(new ReplaceAction(out), new Exit());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit" + ln
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Input in = new StubInput(new String[] {"5", "0"});
        List<UserAction> actions = List.of(new Exit());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu:" + ln
                + "0. Exit" + ln
                + "Wrong input, you can select: 0 .. 0" + ln
                + "Menu:" + ln
                + "0. Exit" + ln));
    }

    @Test
    public void whenFindbyId() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("test"));
        List<UserAction> actions = List.of(new FindByIdAction(out), new Exit());
        Input in = new StubInput(new String[]{"0", String.valueOf(item.getId()), "1"});
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu:" + ln
                           + "0. Find item by id" + ln
                           + "1. Exit" + ln
                           + "=== Find item by id ===" + ln
                           + item + ln
                           + "Menu:" + ln
                           + "0. Find item by id" + ln
                           + "1. Exit" + ln));
    }

    @Test
    public void whenFindbyName() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("test"));
        List<UserAction> actions = List.of(new FindByNameAction(out), new Exit());
        Input in = new StubInput(new String[]{"0", String.valueOf(item.getName()), "1"});
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu:" + ln
                + "0. Find items by name" + ln
                + "1. Exit" + ln
                + "=== Find items by name ===" + ln
                + item + ln
                + "Menu:" + ln
                + "0. Find items by name" + ln
                + "1. Exit" + ln));
    }

    @Test
    public void whenFindbyAllItems() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("test"));
        Item item2 = tracker.add(new Item("test2"));
        List<UserAction> actions = List.of(new ShowItemAction(out), new Exit());
        Input in = new StubInput(new String[]{"0", "1"});
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu:" + ln
                + "0. Show all items" + ln
                + "1. Exit" + ln
                + "=== Show all items ===" + ln
                + item + ln
                + item2 + ln
                + "Menu:" + ln
                + "0. Show all items" + ln
                + "1. Exit" + ln));
    }

}