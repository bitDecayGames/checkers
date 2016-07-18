package com.bitdecay.checkers.conditions;

import com.bitdecay.board.Condition;
import com.bitdecay.checkers.action.WinAction;
import com.bitdecay.checkers.model.Checkerboard;
import com.bitdecay.checkers.model.Piece;
import com.bitdecay.checkers.model.Team;

public class WinCondition extends Condition<Checkerboard, WinAction> {
    public WinCondition() {super(new WinAction());}

    @Override
    public boolean check(Checkerboard previous, Checkerboard current) {
        if (!previous.gameOver && !current.gameOver) {
            boolean blackTeamAlive = false;
            boolean whiteTeamAlive = false;
            for (Piece piece : current.pieces) {
                if (piece.team == Team.BLACK && piece.alive) blackTeamAlive = true;
                else if (piece.team == Team.WHITE && piece.alive) whiteTeamAlive = true;
            }

            if (blackTeamAlive && whiteTeamAlive) return false;
            else if (blackTeamAlive) {
                action.winningTeam = Team.BLACK;
                return true;
            } else if (whiteTeamAlive) {
                action.winningTeam = Team.WHITE;
                return true;
            }
        }
        return false;
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
    public Condition deserialize(String s) {
        return null;
    }
}
