package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class SingletonTest {
    @Test
    public void singletonEnum() {
        Tracker tracker1 = SingletonEnum.INSTANCE.getTracker();
        Tracker tracker2 = SingletonEnum.INSTANCE.getTracker();

        assertSame(tracker1, tracker2);
    }

    @Test
    public void SingletonPrivateStaticFinalClass() {
        Tracker tracker1 = SingletonPrivateStaticFinalClass.getInstance();
        Tracker tracker2 = SingletonPrivateStaticFinalClass.getInstance();

        assertSame(tracker1, tracker2);
    }

    @Test
    public void SingletonStaticField() {
        Tracker tracker1 = SingletonStaticField.getInstance();
        Tracker tracker2 = SingletonStaticField.getInstance();

        assertSame(tracker1, tracker2);
    }

    @Test
    public void SingletonStaticFinalField() {
        Tracker tracker1 = SingletonStaticFinalField.getInstance();
        Tracker tracker2 = SingletonStaticFinalField.getInstance();

        assertSame(tracker1, tracker2);
    }
}
