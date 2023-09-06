package com.ldav.tareaclase3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntervalTest {

    @Test
    public void closedIntervalValidCreation() {
        Assertions.assertDoesNotThrow(() -> {
            ClosedInterval.createFrom(0d, 2d);
        });
    }

    @Test
    public void closedIntervalMustHaveDefinedEnds() {
        IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ClosedInterval.createFrom(Double.POSITIVE_INFINITY, 2d);
        });

        Assertions.assertEquals("Closed intervals must have defined ends. Not infinity!", ex.getMessage());
    }

    @Test
    public void intervalEndGreaterThanIntervalStart() {
        IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ClosedInterval.createFrom(3d, 2d);
        });

        Assertions.assertEquals("Start can't be greater than end!", ex.getMessage());
    }

    @Test
    public void closedIntervalToString() {
        Interval closedInterval = ClosedInterval.createFrom(0d, 2d);

        Assertions.assertEquals("[0.0;2.0]", closedInterval.toString());
    }

    @Test
    public void intervalContainsItself() {
        Interval interval = ClosedInterval.createFrom(0d, 10d);

        Assertions.assertTrue(interval.contains(interval));
    }

    @Test
    public void closedIntervalContainsNumber() {
        Interval interval = ClosedInterval.createFrom(0d, 10d);

        Assertions.assertTrue(interval.contains(5d));
        Assertions.assertTrue(interval.contains(0));
        Assertions.assertFalse(interval.contains(11d));
    }

    @Test
    public void closedIntervalContainsClosedInterval() {
        Interval bigger = ClosedInterval.createFrom(0d, 10d);
        Interval smaller = ClosedInterval.createFrom(2d, 3d);

        Assertions.assertTrue(bigger.contains(smaller));
        Assertions.assertFalse(smaller.contains(bigger));
    }

    @Test
    public void closedBiggerThanOpened() {
        Interval bigger = ClosedInterval.createFrom(0d, 10d);
        Interval smaller = OpenedInterval.createFrom(0d, 10d);

        Assertions.assertTrue(bigger.compareTo(smaller) > 0);
        Assertions.assertTrue(smaller.compareTo(bigger) < 0);
        Assertions.assertEquals(0, smaller.compareTo(smaller));

    }
}
