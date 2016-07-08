package com.bitdecay.checkers.rule;

import com.bitdecay.board.Action;
import com.bitdecay.board.Rule;
import com.bitdecay.checkers.action.JumpAction;
import com.bitdecay.checkers.action.MoveAction;
import com.bitdecay.checkers.model.Checkerboard;
import com.bitdecay.checkers.model.MoveDirection;
import com.bitdecay.checkers.model.Piece;
import com.bitdecay.checkers.model.Team;

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
