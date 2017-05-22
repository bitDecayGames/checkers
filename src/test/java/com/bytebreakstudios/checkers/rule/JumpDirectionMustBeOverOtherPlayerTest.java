package com.bytebreakstudios.checkers.rule;

import com.bytebreakstudios.checkers.action.JumpAction;
import com.bytebreakstudios.checkers.model.MoveDirection;
import com.bytebreakstudios.checkers.model.Piece;
import org.junit.Assert;
import org.junit.Test;

public class JumpDirectionMustBeOverOtherPlayerTest {

    private JumpDirectionMustBeOverOtherPieceRule rule = new JumpDirectionMustBeOverOtherPieceRule();

    @Test
    public void testJumpDirectionOverOtherPlayer(){
        Assert.assertTrue(rule.apply(null, null, new JumpAction(new Piece().setPosition(0, 0), new Piece().setPosition(1, 1), MoveDirection.DOWNRIGHT)));
    }

    @Test
    public void testJumpDirectionNotOverOtherPlayer(){
        Assert.assertFalse(rule.apply(null, null, new JumpAction(new Piece().setPosition(0, 0), new Piece().setPosition(1, 1), MoveDirection.UPRIGHT)));
    }
}
