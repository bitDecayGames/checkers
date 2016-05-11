package com.bitdecay.checkers.model;

import com.bitdecay.board.utils.GameBoardException;
import com.bitdecay.board.utils.Serializable;

public class Piece implements Serializable<Piece> {
    public int id = 0;
    public Team team = Team.A;
    public boolean king = false;
    public boolean alive = false;
    public int x = 0;
    public int y = 0;


    @Override
    public String serialize() {
        switch (team){
            case A:
                return "  /`" + id + "`\\  \n" +
                        " |" + (king ? "  K  " : "     ") + "| \n" +
                        "  \\.../  ";
            case B:
                return "  /=" + id + "=\\  \n" +
                        " |" + (king ? "# K #" : "&&&&&") + "| \n" +
                        "  \\&&&/  ";
            default: throw new GameBoardException("There should only be two teams in checkers");
        }
    }

    @Override
    public Piece deserialize(String s) {
        team = s.contains("&") ? Team.B : Team.A;
        king = s.contains("K");
        alive = true;
        switch (team){
            case A:
                id = Integer.parseInt(s.split("`")[1]);
                break;
            case B:
                id = Integer.parseInt(s.split("=")[1]);
                break;
        }
        return this;
    }

    @Override
    public String toString(){ return serialize(); }
}