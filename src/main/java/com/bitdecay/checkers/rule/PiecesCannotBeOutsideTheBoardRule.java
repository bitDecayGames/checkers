package com.bitdecay.checkers.rule;

import com.bitdecay.board.Action;
import com.bitdecay.board.Rule;
import com.bitdecay.checkers.model.Checkerboard;

public class PiecesCannotBeOutsideTheBoardRule implements Rule<Checkerboard> {
    @Override
    public boolean apply(Checkerboard current, Checkerboard next, Action action) {
        return !next.stream().filter(p -> p.alive && (p.x < 0 || p.y < 0 || p.x >= next.size || p.y >= next.size)).findFirst().isPresent();
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
    public Rule deserialize(String s) { return null; }
}
