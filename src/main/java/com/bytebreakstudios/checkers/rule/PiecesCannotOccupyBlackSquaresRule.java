package com.bytebreakstudios.checkers.rule;

import com.bytebreakstudios.checkers.model.Checkerboard;
import com.bytebreakstudios.board.Action;
import com.bytebreakstudios.board.Rule;

public class PiecesCannotOccupyBlackSquaresRule implements Rule<Checkerboard> {
    @Override
    public boolean apply(Checkerboard current, Checkerboard next, Action action) {
        return !next.stream().filter(piece -> (piece.x + piece.y) % 2 != 0).findFirst().isPresent();
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
