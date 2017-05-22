package com.bytebreakstudios.checkers.action;

import com.bytebreakstudios.checkers.model.Checkerboard;
import com.bytebreakstudios.checkers.model.MoveDirection;
import com.bytebreakstudios.checkers.model.Piece;
import com.bytebreakstudios.board.Action;
import com.bytebreakstudios.board.utils.GameBoardException;

import java.util.Optional;

public class JumpAction extends Action<Checkerboard> {
    public Piece jumper;
    public Piece jumpee;
    public MoveDirection direction;
    public JumpAction(Piece jumper, Piece jumpee, MoveDirection direction){
        if (jumper == null) throw new GameBoardException("Jumper and Jumpee cannot be null");
        if (direction == null) throw new GameBoardException("Direction cannot be null");
        this.jumper = jumper;
        this.jumpee = jumpee;
        this.direction = direction;
    }

    public JumpAction(Piece jumper, MoveDirection direction){
        if (jumper == null) throw new GameBoardException("Jumper and Jumpee cannot be null");
        if (direction == null) throw new GameBoardException("Direction cannot be null");
        this.jumper = jumper;
        this.direction = direction;
    }

    @Override
    protected Checkerboard innerApply(Checkerboard current) {
        Checkerboard next = (Checkerboard) current.clone();
        Optional<Piece> optJumper = next.getPieceWithId(jumper.team, jumper.id);
        if (optJumper.isPresent()){
            Piece jumper = optJumper.get();
            jumper.x += direction.x() * 2;
            jumper.y += direction.y() * 2;
            next.lastPieceToMove = jumper;
        }
        if (jumpee == null){
            Optional<Piece> findJumpee = current.getJumpedPieceAt(jumper, direction);
            jumpee = (findJumpee.isPresent() ? findJumpee.get() : null);
        }
        if (jumpee != null) {
            Optional<Piece> optJumpee = next.getPieceWithId(jumpee.team, jumpee.id);
            if (optJumpee.isPresent()) {
                Piece jumpee = optJumpee.get();
                jumpee.alive = false;
                jumpee.x = -1;
                jumpee.y = -1;
            }
        }
        return next;
    }

    @Override
    protected Checkerboard innerUnapply(Checkerboard current){
        Checkerboard next = (Checkerboard) current.clone();
        Optional<Piece> optJumper = next.getPieceWithId(jumper.team, jumper.id);
        Optional<Piece> optJumpee = next.getPieceWithId(jumpee.team, jumpee.id);
        if (optJumper.isPresent()){
            Piece jumper = optJumper.get();
            jumper.x -= direction.x() * 2;
            jumper.y -= direction.y() * 2;
        }
        if (optJumpee.isPresent()){
            Piece jumpee = optJumpee.get();
            jumpee.alive = true;
        }
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
