package com.bytebreakstudios.checkers.action;

import com.bytebreakstudios.checkers.model.Checkerboard;
import com.bytebreakstudios.checkers.model.Team;
import com.bytebreakstudios.board.Action;

public class WinAction extends Action<Checkerboard> {
    public Team winningTeam = null;

    public WinAction(){}
    public WinAction(Team winningTeam){
        this.winningTeam = winningTeam;
    }

    @Override
    protected Checkerboard innerApply(Checkerboard checkerboard) {
        Checkerboard c = (Checkerboard) checkerboard.clone();
        c.winner = winningTeam;
        c.gameOver = true;
        return c;
    }

    @Override
    protected Checkerboard innerUnapply(Checkerboard checkerboard) {
        Checkerboard c = (Checkerboard) checkerboard.clone();
        c.winner = null;
        c.gameOver = false;
        return c;
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
