package com.bytebreakstudios.checkers.rule;

import com.bytebreakstudios.checkers.action.MoveAction;
import com.bytebreakstudios.checkers.model.MoveDirection;
import com.bytebreakstudios.checkers.model.Piece;
import org.junit.Assert;
import org.junit.Test;

public class PieceMustBeAliveToMoveItTest {

    private PieceMustBeAliveToMoveItRule rule = new PieceMustBeAliveToMoveItRule();

    @Test
    public void testMoveAlivePiece(){
        Assert.assertTrue(rule.apply(null, null, new MoveAction(new Piece(), MoveDirection.DOWNLEFT)));
    }

    @Test
    public void testMoveDeadPiece(){
        Assert.assertFalse(rule.apply(null, null, new MoveAction(new Piece().setAlive(false), MoveDirection.DOWNLEFT)));
    }
}
