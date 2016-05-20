package com.bitdecay.checkers.model;

import com.bitdecay.board.utils.GameBoardException;

public class Move {
    private Piece piece;
    private int x;
    private int y;
    private boolean isHop = false;
    public Move(Piece piece, int x, int y){
        if (piece == null) throw new GameBoardException("Piece cannot be null");
        this.piece = piece;
        this.x = x;
        this.y = y;
        this.isHop = Math.abs(piece.x - x) > 1;
    }

    public Piece piece(){return piece;}
    public int x(){return x;}
    public int y(){return y;}
    public boolean isHop(){return isHop;}
}
