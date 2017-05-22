package com.bytebreakstudios.checkers.condition;

import com.bytebreakstudios.checkers.conditions.WinCondition;
import com.bytebreakstudios.checkers.model.Checkerboard;
import org.junit.Assert;
import org.junit.Test;

public class WinConditionTest {

    private WinCondition condition = new WinCondition();

    @Test
    public void testWinCondition(){
        Checkerboard previous = new Checkerboard(6);
        Checkerboard current = new Checkerboard(6);
        current.stream().forEach(piece -> piece.alive = false);
        current.stream().findFirst().ifPresent(piece -> piece.alive = true);
        Assert.assertTrue(condition.check(previous, current));
    }

    @Test
    public void testNoWinCondition(){
        Assert.assertFalse(condition.check(new Checkerboard(6), new Checkerboard(6)));
    }
}
