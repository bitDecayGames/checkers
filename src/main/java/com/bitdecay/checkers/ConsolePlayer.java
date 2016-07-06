package com.bitdecay.checkers;

import com.bitdecay.board.Conditions;
import com.bitdecay.board.GameBoard;
import com.bitdecay.board.Rules;
import com.bitdecay.checkers.action.ChangeTurnAction;
import com.bitdecay.checkers.action.MoveAction;
import com.bitdecay.checkers.conditions.WinCondition;
import com.bitdecay.checkers.model.Checkerboard;
import com.bitdecay.checkers.model.Move;
import com.bitdecay.checkers.model.Piece;
import com.bitdecay.checkers.rule.PiecesCannotOccupyBlackSquaresRule;
import com.bitdecay.checkers.rule.PiecesCannotOccupyTheSameSquareRule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

public class ConsolePlayer {
    public static void main(String[] args){
        GameBoard<Checkerboard> gameBoard = new GameBoard<>(new Checkerboard(8), new Rules<>(new PiecesCannotOccupyBlackSquaresRule(), new PiecesCannotOccupyTheSameSquareRule()), new Conditions<>(new WinCondition()));

        Checkerboard currentState = gameBoard.currentState();

        while(!currentState.gameOver){
            println(currentState.serialize());
            println("It is " + currentState.currentTurn + "'s turn");
            gameBoard.submitAction(new MoveAction(getMove(currentState)));
            gameBoard.submitAction(new ChangeTurnAction());
            gameBoard.step();
            currentState = gameBoard.currentState();
        }

    }

    private static Move getMove(Checkerboard currentState){
        String idStr = "";
        int id = -1;
        Optional<Piece> pOpt = Optional.empty();
        boolean isIdValid = false;
        while (!isIdValid){
            println("Enter Id: ");
            idStr = getInput();
            try {
                id = Integer.parseInt(idStr);
                pOpt = currentState.getPieceWithId(currentState.currentTurn, id);
                if (pOpt.isPresent()) isIdValid = true;
                else throw new Exception();
            } catch (Exception e){
                println("Id '" + idStr + "' is not a valid " + currentState.currentTurn + " piece id");
            }
        }
        Piece p = pOpt.get();

        String moveStr = "";
        while(true){
            println("Enter move (upleft, downleft, upright, downright): ");
            moveStr = getInput();
            if (moveStr != null){
                if (moveStr.equalsIgnoreCase("upleft")) return new Move(p, p.x - 1, p.y - 1);
                else if (moveStr.equalsIgnoreCase("downleft")) return new Move(p, p.x - 1, p.y + 1);
                else if (moveStr.equalsIgnoreCase("upright")) return new Move(p, p.x + 1, p.y - 1);
                else if (moveStr.equalsIgnoreCase("downright")) return new Move(p, p.x + 1, p.y + 1);
            }
            println("Move is not valid, try again");
        }
    }

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String getInput(){
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
    private static void println(String msg){System.out.println(msg);}
}
