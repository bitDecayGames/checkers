package com.bytebreakstudios.checkers.rule;

import com.bytebreakstudios.checkers.action.JumpAction;
import com.bytebreakstudios.checkers.action.MoveAction;
import com.bytebreakstudios.checkers.model.Checkerboard;
import com.bytebreakstudios.board.Action;
import com.bytebreakstudios.board.Rule;

public class PieceMustBeAliveToMoveItRule implements Rule<Checkerboard> {
    @Override
    public boolean apply(Checkerboard current, Checkerboard next, Action action) {
        if (action instanceof JumpAction){
            JumpAction a = (JumpAction) action;
            return a.jumper.alive && a.jumpee != null && a.jumpee.alive;
        } else if (action instanceof MoveAction){
            MoveAction a = (MoveAction) action;
            return a.piece.alive;
        } else return true;
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
