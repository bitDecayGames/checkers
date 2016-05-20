package com.bitdecay.checkers.utils;

import com.bitdecay.checkers.model.Checkerboard;
import com.bitdecay.checkers.model.Move;
import com.bitdecay.checkers.model.Piece;
import com.bitdecay.checkers.model.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MoveFinder {
    public static List<Move> getAvailableMovesForCurrentTurn(Checkerboard board){
        final List<Move> moves = new ArrayList<>();
        board.stream().filter(p -> p.team == board.currentTurn).forEach(p -> {
            List<Move> tmp = getAvailableMovesForPiece(board, p);
            moves.addAll(tmp);
        });
        return moves;
    }

    public static List<Move> getAvailableMovesForPiece(Checkerboard board, Piece piece){
        List<Move> moves = new ArrayList<>();
        Move move = new Move(piece, piece.x + 1, piece.y + 1);
        if (isValidMove(board, move)) moves.add(move);
        move = new Move(piece, piece.x - 1, piece.y + 1);
        if (isValidMove(board, move)) moves.add(move);
        move = new Move(piece, piece.x + 1, piece.y - 1);
        if (isValidMove(board, move)) moves.add(move);
        move = new Move(piece, piece.x - 1, piece.y - 1);
        if (isValidMove(board, move)) moves.add(move);

        move = new Move(piece, piece.x + 2, piece.y + 2);
        if (isValidMove(board, move)) moves.add(move);
        move = new Move(piece, piece.x - 2, piece.y + 2);
        if (isValidMove(board, move)) moves.add(move);
        move = new Move(piece, piece.x + 2, piece.y - 2);
        if (isValidMove(board, move)) moves.add(move);
        move = new Move(piece, piece.x - 2, piece.y - 2);
        if (isValidMove(board, move)) moves.add(move);
        return moves;
    }

    public static boolean isValidMove(Checkerboard board, Move move){
        Optional<Piece> occupyingPiece = board.getPieceAt(move.x(), move.y());
        Optional<Piece> hoppedPiece = getHoppedPiece(board, move);
        int absDiffX = Math.abs(move.x() - move.piece().x);
        int absDiffY = Math.abs(move.y() - move.piece().y);
        return !(!move.piece().alive ||
                move.x() == move.piece().x ||
                move.y() == move.piece().y ||
                absDiffX > 2 ||
                absDiffY > 2 ||
                (absDiffX + absDiffY) % 2 != 0 ||
                move.x() < 0 ||
                move.y() < 0 ||
                move.x() >= board.size ||
                move.y() >= board.size ||
                move.piece().team != board.currentTurn ||
                (!move.piece().king && move.piece().team == Team.WHITE && move.y() < move.piece().y) ||
                (!move.piece().king && move.piece().team == Team.BLACK && move.y() > move.piece().y) ||
                (occupyingPiece.isPresent() && occupyingPiece.get().alive) ||
                (move.isHop() && !hoppedPiece.isPresent()) ||
                (move.isHop() && hoppedPiece.isPresent() && hoppedPiece.get().alive && hoppedPiece.get().team == move.piece().team));
    }

    public static Optional<Piece> getHoppedPiece(Checkerboard board, Move move){
        return move.isHop() ? board.getPieceAt(move.x() / 2, move.y() / 2) : Optional.empty();
    }
}
