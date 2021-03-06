package com.bytebreakstudios.checkers.action;

import com.bytebreakstudios.checkers.model.Checkerboard;
import com.bytebreakstudios.checkers.model.Team;
import com.bytebreakstudios.board.Action;

public class ChangeTurnAction extends Action<Checkerboard> {
    @Override
    protected Checkerboard innerApply(Checkerboard checkerboard) {
        Checkerboard c = (Checkerboard) checkerboard.clone();
        if (c.currentTurn == Team.BLACK) c.currentTurn = Team.WHITE;
        else c.currentTurn = Team.BLACK;
        return c;
    }

    @Override
    protected Checkerboard innerUnapply(Checkerboard checkerboard) {
        return innerApply(checkerboard);
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
    public Object deserialize(String s) {
        return null;
    }
}
