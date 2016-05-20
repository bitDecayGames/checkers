package com.bitdecay.checkers.action;

import com.bitdecay.board.Action;
import com.bitdecay.board.utils.GameBoardException;
import com.bitdecay.checkers.model.Checkerboard;
import com.bitdecay.checkers.model.Move;
import com.bitdecay.checkers.model.Piece;
import com.bitdecay.checkers.utils.MoveFinder;

import java.util.Optional;

public class MoveAction extends Action<Checkerboard> {
    public Move move;
    public MoveAction(Move move){
        if (move == null) throw new GameBoardException("Move cannot be null");
        this.move = move;
    }

    @Override
    protected Checkerboard innerApply(Checkerboard current) {
        Checkerboard next = (Checkerboard) current.clone();
        Optional<Piece> optPiece = next.getPieceWithId(move.piece().team, move.piece().id);
        if (optPiece.isPresent()){
            Optional<Piece> hoppedPiece = MoveFinder.getHoppedPiece(next, move);
            if (hoppedPiece.isPresent()) hoppedPiece.get().alive = false;
            Piece p = optPiece.get();
            p.x = move.x();
            p.y = move.y();
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
