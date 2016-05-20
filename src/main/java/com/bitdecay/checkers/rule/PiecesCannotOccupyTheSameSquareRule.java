package com.bitdecay.checkers.rule;

import com.bitdecay.board.Action;
import com.bitdecay.board.Rule;
import com.bitdecay.checkers.model.Checkerboard;

public class PiecesCannotOccupyTheSameSquareRule implements Rule<Checkerboard> {
    @Override
    public boolean apply(Checkerboard current, Checkerboard next, Action action) {
        return !next.stream().filter(a -> next.stream().filter(b -> a != b && a.alive && b.alive && a.x == b.x && a.y == b.y).findFirst().isPresent()).findFirst().isPresent();
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
    public Rule deserialize(String s) {
        return null;
    }
}
