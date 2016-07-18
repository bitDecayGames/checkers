package com.bitdecay.checkers.rule;

import com.bitdecay.checkers.action.JumpAction;
import com.bitdecay.checkers.model.MoveDirection;
import com.bitdecay.checkers.model.Piece;
import com.bitdecay.checkers.model.Team;
import org.junit.Assert;
import org.junit.Test;

public class PiecesCanOnlyJumpTheOtherTeamTest {

    private PiecesCanOnlyJumpTheOtherTeamRule rule = new PiecesCanOnlyJumpTheOtherTeamRule();

    @Test
    public void testJumpOtherTeam(){
        Assert.assertTrue(rule.apply(null, null, new JumpAction(new Piece().setPosition(0, 0), new Piece().setPosition(1, 1).setTeam(Team.BLACK), MoveDirection.DOWNRIGHT)));
    }

    @Test
    public void testJumpSameTeam(){
        Assert.assertFalse(rule.apply(null, null, new JumpAction(new Piece().setPosition(0, 0), new Piece().setPosition(1, 1), MoveDirection.DOWNRIGHT)));
    }
}
