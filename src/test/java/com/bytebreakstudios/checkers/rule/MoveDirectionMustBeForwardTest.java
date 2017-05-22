package com.bytebreakstudios.checkers.rule;

import com.bytebreakstudios.checkers.action.MoveAction;
import com.bytebreakstudios.checkers.model.MoveDirection;
import com.bytebreakstudios.checkers.model.Piece;
import com.bytebreakstudios.checkers.model.Team;
import org.junit.Assert;
import org.junit.Test;

public class MoveDirectionMustBeForwardTest {

    private MoveDirectionMustBeForwardRule rule = new MoveDirectionMustBeForwardRule();

    @Test
    public void testMoveDirectionForward(){
        Assert.assertTrue(rule.apply(null, null, new MoveAction(new Piece(), MoveDirection.DOWNLEFT)));
    }

    @Test
    public void testMoveDirectionBackward(){
        Assert.assertFalse(rule.apply(null, null, new MoveAction(new Piece().setTeam(Team.BLACK), MoveDirection.DOWNLEFT)));
    }

    @Test
    public void testMoveKingForward(){
        Assert.assertTrue(rule.apply(null, null, new MoveAction(new Piece().setKing(true), MoveDirection.DOWNLEFT)));
    }

    @Test
    public void testMoveKingBackward(){
        Assert.assertTrue(rule.apply(null, null, new MoveAction(new Piece().setKing(true), MoveDirection.UPRIGHT)));
    }
}
