package org.minesweeper.model.game.elements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FlagCounterTest {
    @Test
    void testConstructor1() {
        FlagCounter actualFlagCounter = new FlagCounter(3);
        actualFlagCounter.increment();
        assertEquals(4, actualFlagCounter.getCounter());
    }

    @Test
    void testConstructor2() {
        FlagCounter actualFlagCounter = new FlagCounter(3);
        actualFlagCounter.decrement();
        assertEquals(2, actualFlagCounter.getCounter());
    }
}

