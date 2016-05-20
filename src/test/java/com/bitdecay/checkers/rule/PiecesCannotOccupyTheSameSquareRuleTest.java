package com.bitdecay.checkers.rule;

import com.bitdecay.board.utils.GameBoardException;
import com.bitdecay.checkers.model.Checkerboard;
import com.bitdecay.checkers.model.Piece;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class PiecesCannotOccupyTheSameSquareRuleTest {

    @Test
    public void testPiecesCannotOccupyTheSameSquareRulePass(){
        Checkerboard a = new Checkerboard(6);
        Checkerboard b = new Checkerboard(6);
        PiecesCannotOccupyTheSameSquareRule rule = new PiecesCannotOccupyTheSameSquareRule();
        Assert.assertTrue(rule.apply(a, b, null));
    }

    @Test
    public void testPiecesCannotOccupyTheSameSquareRuleFail(){
        Checkerboard a = new Checkerboard(6);
        Checkerboard b = new Checkerboard(6);
        Optional<Piece> piece = b.getPieceAt(0, 0);
        if (piece.isPresent()) piece.get().x += 2;
        else throw new GameBoardException("There should have been a piece at (0, 0)");
        PiecesCannotOccupyTheSameSquareRule rule = new PiecesCannotOccupyTheSameSquareRule();
        Assert.assertFalse(rule.apply(a, b, null));
    }
}
