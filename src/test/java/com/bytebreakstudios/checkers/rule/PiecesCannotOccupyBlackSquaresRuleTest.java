package com.bytebreakstudios.checkers.rule;

import com.bytebreakstudios.checkers.model.Checkerboard;
import com.bytebreakstudios.checkers.model.Piece;
import com.bytebreakstudios.board.utils.GameBoardException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class PiecesCannotOccupyBlackSquaresRuleTest {

    private PiecesCannotOccupyBlackSquaresRule rule = new PiecesCannotOccupyBlackSquaresRule();

    @Test
    public void testPiecesCannotOccupyBlackSquaresRulePass(){
        Checkerboard a = new Checkerboard(6);
        Checkerboard b = new Checkerboard(6);
        Assert.assertTrue(rule.apply(a, b, null));
    }

    @Test
    public void testPiecesCannotOccupyBlackSquaresRuleFail(){
        Checkerboard a = new Checkerboard(6);
        Checkerboard b = new Checkerboard(6);
        Optional<Piece> piece = b.getPieceAt(0, 0);
        if (piece.isPresent()) piece.get().x += 1;
        else throw new GameBoardException("There should have been a piece at (0, 0)");
        Assert.assertFalse(rule.apply(a, b, null));
    }
}
