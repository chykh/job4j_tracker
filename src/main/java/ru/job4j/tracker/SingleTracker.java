package ru.job4j.tracker;

public final class SingleTracker {
    private static Store tracker = null;

    private SingleTracker() {
    }

    public static Store getTracker() {
        if (tracker == null) {
            tracker = new MemTracker();
        }
        return tracker;
    }

}