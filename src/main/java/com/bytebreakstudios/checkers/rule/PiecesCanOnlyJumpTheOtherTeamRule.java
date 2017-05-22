package com.bytebreakstudios.checkers.rule;

import com.bytebreakstudios.checkers.action.JumpAction;
import com.bytebreakstudios.checkers.model.Checkerboard;
import com.bytebreakstudios.board.Action;
import com.bytebreakstudios.board.Rule;

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
