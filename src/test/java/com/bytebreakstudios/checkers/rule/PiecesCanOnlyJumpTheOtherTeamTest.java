package com.bytebreakstudios.checkers.rule;

import com.bytebreakstudios.checkers.action.JumpAction;
import com.bytebreakstudios.checkers.model.MoveDirection;
import com.bytebreakstudios.checkers.model.Piece;
import com.bytebreakstudios.checkers.model.Team;
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
