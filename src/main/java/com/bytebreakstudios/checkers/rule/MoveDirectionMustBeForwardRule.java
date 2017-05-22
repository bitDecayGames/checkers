package com.bytebreakstudios.checkers.rule;

import com.bytebreakstudios.checkers.action.JumpAction;
import com.bytebreakstudios.checkers.action.MoveAction;
import com.bytebreakstudios.checkers.model.Checkerboard;
import com.bytebreakstudios.checkers.model.MoveDirection;
import com.bytebreakstudios.checkers.model.Piece;
import com.bytebreakstudios.checkers.model.Team;
import com.bytebreakstudios.board.Action;
import com.bytebreakstudios.board.Rule;

public class MoveDirectionMustBeForwardRule implements Rule<Checkerboard> {
    @Override
    public boolean apply(Checkerboard current, Checkerboard next, Action action) {
        if (action instanceof JumpAction || action instanceof MoveAction){
            Piece piece = (action instanceof JumpAction ? ((JumpAction) action).jumper : ((MoveAction) action).piece);
            if (!piece.king) {
                Team team = piece.team;
                MoveDirection d = (action instanceof JumpAction ? ((JumpAction) action).direction : ((MoveAction) action).direction);
                return (team == Team.BLACK && (d == MoveDirection.UPLEFT || d == MoveDirection.UPRIGHT)) || (team == Team.WHITE && (d == MoveDirection.DOWNLEFT || d == MoveDirection.DOWNRIGHT));
            }
        }
        return true;
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
