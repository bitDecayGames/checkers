package com.bitdecay.checkers.rule;

import com.bitdecay.board.Action;
import com.bitdecay.board.Rule;
import com.bitdecay.checkers.action.JumpAction;
import com.bitdecay.checkers.model.Checkerboard;

public class PiecesCanOnlyJumpTheOtherTeamRule implements Rule<Checkerboard> {
    @Override
    public boolean apply(Checkerboard current, Checkerboard next, Action action) {
        return !(action instanceof JumpAction) || ((JumpAction) action).jumper.team != ((JumpAction) action).jumpee.team;
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
