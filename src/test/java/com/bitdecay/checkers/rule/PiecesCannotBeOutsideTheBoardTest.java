package com.bitdecay.checkers.rule;

import com.bitdecay.checkers.model.Checkerboard;
import org.junit.Assert;
import org.junit.Test;

public class PiecesCannotBeOutsideTheBoardTest {

    private PiecesCannotBeOutsideTheBoardRule rule = new PiecesCannotBeOutsideTheBoardRule();

    @Test
    public void testPieceWithinTheBoard(){
        Checkerboard board = new Checkerboard(6);
        Assert.assertTrue(rule.apply(null, board, null));
    }

    @Test
    public void testPieceLessThanTheBoard(){
        Checkerboard board = new Checkerboard(6);
        board.getPieceAt(0, 0).ifPresent(p -> {
            p.x = -1;
            p.y = -1;
        });
        Assert.assertFalse(rule.apply(null, board, null));
    }

    @Test
    public void testPieceGreaterThanTheBoard(){
        Checkerboard board = new Checkerboard(6);
        board.getPieceAt(0, 0).ifPresent(p -> {
            p.x = board.size;
            p.y = board.size;
        });
        Assert.assertFalse(rule.apply(null, board, null));
    }
}
