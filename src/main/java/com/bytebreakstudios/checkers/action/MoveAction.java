package com.bytebreakstudios.checkers.action;

import com.bytebreakstudios.checkers.model.Checkerboard;
import com.bytebreakstudios.checkers.model.MoveDirection;
import com.bytebreakstudios.checkers.model.Piece;
import com.bytebreakstudios.board.Action;
import com.bytebreakstudios.board.utils.GameBoardException;

import java.util.Optional;

public class MoveAction extends Action<Checkerboard> {
    public Piece piece;
    public MoveDirection direction;
    public MoveAction(Piece piece, MoveDirection direction){
        if (piece == null) throw new GameBoardException("Piece cannot be null");
        if (direction == null) throw new GameBoardException("Direction cannot be null");
        this.piece = piece;
        this.direction = direction;
    }

    @Override
    protected Checkerboard innerApply(Checkerboard current) {
        Checkerboard next = (Checkerboard) current.clone();
        Optional<Piece> optPiece = next.getPieceWithId(piece.team, piece.id);
        if (optPiece.isPresent()){
            Piece p = optPiece.get();
            p.x += direction.x();
            p.y += direction.y();
            next.lastPieceToMove = p;
        }
        return next;
    }

    @Override
    protected Checkerboard innerUnapply(Checkerboard current) {
        return null;
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
