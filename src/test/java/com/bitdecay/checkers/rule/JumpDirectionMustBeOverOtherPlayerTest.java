package com.bitdecay.checkers.rule;

import com.bitdecay.checkers.action.JumpAction;
import com.bitdecay.checkers.model.MoveDirection;
import com.bitdecay.checkers.model.Piece;
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
