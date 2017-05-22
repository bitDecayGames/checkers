package com.bytebreakstudios.checkers.condition;

import com.bytebreakstudios.checkers.conditions.KingMeCondition;
import com.bytebreakstudios.checkers.model.Checkerboard;
import com.bytebreakstudios.checkers.model.Team;
import org.junit.Assert;
import org.junit.Test;

public class KingMeConditionTest {

    private KingMeCondition condition = new KingMeCondition();

    @Test
    public void testKingMeCondition(){
        Checkerboard previous = new Checkerboard(6);
        Checkerboard current = new Checkerboard(6);
        current.stream().findFirst().ifPresent(piece -> {
            if (piece.team == Team.WHITE) piece.y = current.size - 1;
            else piece.y = 0;
        });
        Assert.assertTrue(condition.check(previous, current));
    }

    @Test
    public void testNoKingMeCondition(){
        Assert.assertFalse(condition.check(new Checkerboard(6), new Checkerboard(6)));
    }
}
