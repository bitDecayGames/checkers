package com.bitdecay.checkers.rule;

import com.bitdecay.board.Action;
import com.bitdecay.board.Rule;
import com.bitdecay.checkers.action.JumpAction;
import com.bitdecay.checkers.action.MoveAction;
import com.bitdecay.checkers.model.Checkerboard;

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
