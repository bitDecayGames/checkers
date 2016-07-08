package com.bitdecay.checkers.conditions;

import com.bitdecay.board.Condition;
import com.bitdecay.checkers.action.KingMeAction;
import com.bitdecay.checkers.model.Checkerboard;
import com.bitdecay.checkers.model.Piece;
import com.bitdecay.checkers.model.Team;

import java.util.Optional;

public class KingMeCondition extends Condition<Checkerboard, KingMeAction> {
    public KingMeCondition() {super(new KingMeAction());}

    @Override
    public boolean check(Checkerboard previous, Checkerboard current) {
        Optional<Piece> piece = current.stream().filter(p -> (p.team == Team.BLACK && p.y == 0) || (p.team == Team.WHITE && p.y == current.size - 1)).findFirst();
        if (piece.isPresent()) action.setPiece(piece.get());
        return piece.isPresent();
    }

    @Override
    public String description() {
        return null;
    }

    @Override
    public String serialize() {
        return null;
    }

    @Override
    public Condition deserialize(String s) {
        return null;
    }
}
