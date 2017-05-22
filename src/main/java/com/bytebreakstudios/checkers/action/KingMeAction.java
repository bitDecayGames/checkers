package com.bytebreakstudios.checkers.action;

import com.bytebreakstudios.checkers.model.Checkerboard;
import com.bytebreakstudios.checkers.model.Piece;
import com.bytebreakstudios.board.Action;
import com.bytebreakstudios.board.utils.GameBoardException;

import java.util.Optional;

public class KingMeAction extends Action<Checkerboard> {
    private Piece piece;

    public void setPiece(Piece piece){
        if (piece == null) throw new GameBoardException("Piece cannot be null");
        this.piece = piece;
    }

    @Override
    protected Checkerboard innerApply(Checkerboard current) {
        Checkerboard next = (Checkerboard) current.clone();
        Optional<Piece> optPiece = next.getPieceWithId(piece.team, piece.id);
        if (optPiece.isPresent()) optPiece.get().king = true;
        return next;
    }

    @Override
    protected Checkerboard innerUnapply(Checkerboard current){
        Checkerboard next = (Checkerboard) current.clone();
        Optional<Piece> optPiece = next.getPieceWithId(piece.team, piece.id);
        if (optPiece.isPresent()) optPiece.get().king = false;
        return next;
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
