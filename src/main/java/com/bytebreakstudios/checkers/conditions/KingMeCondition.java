package com.bytebreakstudios.checkers.conditions;

import com.bytebreakstudios.checkers.action.KingMeAction;
import com.bytebreakstudios.checkers.model.Checkerboard;
import com.bytebreakstudios.checkers.model.Piece;
import com.bytebreakstudios.checkers.model.Team;
import com.bytebreakstudios.board.Condition;

import java.util.Optional;

public class KingMeCondition extends Condition<Checkerboard, KingMeAction> {
    public KingMeCondition() {super(new KingMeAction());}

    @Override
    public boolean check(Checkerboard previous, Checkerboard current) {
        Optional<Piece> piece = current.stream().filter(p -> (p.team == Team.BLACK && p.y == 0) || (p.team == Team.WHITE && p.y == current.size - 1)).findFirst();
        piece.ifPresent(p -> action.setPiece(p));
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
