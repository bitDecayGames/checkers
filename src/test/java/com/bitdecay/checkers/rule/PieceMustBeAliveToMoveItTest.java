package com.bitdecay.checkers.rule;

import com.bitdecay.checkers.action.MoveAction;
import com.bitdecay.checkers.model.MoveDirection;
import com.bitdecay.checkers.model.Piece;
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
