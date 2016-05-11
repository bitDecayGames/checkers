package com.bitdecay.checkers.model;

import com.bitdecay.board.GameBoardState;
import com.bitdecay.board.utils.CollectionUtils;
import com.bitdecay.board.utils.GameBoardException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class Checkerboard implements GameBoardState{
    private static final String BLACK = "#########";
    private static final String WHITE = "         ";
    private static final String CORNER_SEPARATOR = "+";
    private static final String HORIZONTAL_SEPARATOR = "---------";
    private static final String VERTICAL_SEPARATOR = "|";

    private int size;
    private List<Piece> pieces = new ArrayList<>();

    public Checkerboard(int size){
        if (size < 6) throw new GameBoardException("Game board must be at least 6x6");
        if (size % 2 != 0) throw new GameBoardException("Game board size must be an even number");
        this.size = size;

        for (int i = 0; i < size; i++){
            Piece a = new Piece();
            a.team = Team.A;
            a.alive = true;
            a.id = i + 1;
            a.king = false;
            a.x = i;
            a.y = i % 2;
            pieces.add(a);
            Piece b = new Piece();
            b.team = Team.B;
            b.alive = true;
            b.id = i + 1;
            b.king = false;
            b.x = i;
            b.y = size - 1 - ((i + 1) % 2);
            pieces.add(b);
        }
    }

    @Override
    public String serialize() {
        List<String> stringBuilder = new ArrayList<>();
        for (int y = 0; y < size; y++){
            StringBuilder line1 = new StringBuilder(VERTICAL_SEPARATOR);
            StringBuilder line2 = new StringBuilder(VERTICAL_SEPARATOR);
            StringBuilder line3 = new StringBuilder(VERTICAL_SEPARATOR);
            for (int x = 0; x < size; x++){
                if ((y + x) % 2 == 0){
                    Optional<Piece> piece = getPieceAt(x, y);
                    if (piece.isPresent()){
                        String[] splitPiece = piece.get().serialize().split("\n");
                        line1.append(splitPiece[0]);
                        line2.append(splitPiece[1]);
                        line3.append(splitPiece[2]);
                    } else {
                        line1.append(WHITE);
                        line2.append(WHITE);
                        line3.append(WHITE);
                    }
                } else {
                    line1.append(BLACK);
                    line2.append(BLACK);
                    line3.append(BLACK);
                }
                line1.append(VERTICAL_SEPARATOR);
                line2.append(VERTICAL_SEPARATOR);
                line3.append(VERTICAL_SEPARATOR);
            }
            line1.append("\n");
            line2.append("\n");
            line3.append("\n");
            stringBuilder.add(line1.toString() + line2.toString() + line3.toString());
        }
        List<String> horizontalLines = new ArrayList<>();
        for (int i = 0; i < size; i++) horizontalLines.add(HORIZONTAL_SEPARATOR);
        String longHorizontalSeparator = CollectionUtils.mkString(horizontalLines, CORNER_SEPARATOR, CORNER_SEPARATOR, CORNER_SEPARATOR);

        return CollectionUtils.mkString(stringBuilder, longHorizontalSeparator + "\n", longHorizontalSeparator + "\n", longHorizontalSeparator);
    }

    @Override
    public GameBoardState deserialize(String s) {
        String[] lines = s.split("\n");
        return null;
    }

    @Override
    public Object clone(){
        return null;
    }

    @Override
    public String toString(){ return serialize(); }

    public Optional<Piece> getPieceAt(int x, int y){
        for (Piece p : pieces) if (p.x == x && p.y == y) return Optional.of(p);
        return Optional.empty();
    }
}
