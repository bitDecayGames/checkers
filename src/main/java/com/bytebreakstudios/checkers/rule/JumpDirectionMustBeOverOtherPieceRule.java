package com.bytebreakstudios.checkers.rule;

import com.bytebreakstudios.checkers.action.JumpAction;
import com.bytebreakstudios.checkers.model.Checkerboard;
import com.bytebreakstudios.board.Action;
import com.bytebreakstudios.board.Rule;

public class JumpDirectionMustBeOverOtherPieceRule implements Rule<Checkerboard> {
    @Override
    public boolean apply(Checkerboard current, Checkerboard next, Action action) {
        if (action instanceof JumpAction){
            JumpAction a = (JumpAction) action;
            return a.jumper.x + a.direction.x() == a.jumpee.x && a.jumper.y + a.direction.y() == a.jumpee.y;
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
