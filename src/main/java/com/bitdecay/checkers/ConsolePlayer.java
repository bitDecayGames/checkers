package com.bitdecay.checkers;

import com.bitdecay.board.Action;
import com.bitdecay.board.Conditions;
import com.bitdecay.board.GameBoard;
import com.bitdecay.board.Rules;
import com.bitdecay.checkers.action.ChangeTurnAction;
import com.bitdecay.checkers.action.JumpAction;
import com.bitdecay.checkers.action.MoveAction;
import com.bitdecay.checkers.conditions.KingMeCondition;
import com.bitdecay.checkers.conditions.WinCondition;
import com.bitdecay.checkers.model.Checkerboard;
import com.bitdecay.checkers.model.MoveDirection;
import com.bitdecay.checkers.model.Piece;
import com.bitdecay.checkers.rule.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

public class ConsolePlayer {
    public static void main(String[] args){
        GameBoard<Checkerboard> gameBoard = new GameBoard<>(new Checkerboard(8), new Rules<>(
                new PieceMustBeAliveToMoveItRule(),
                new MoveDirectionMustBeForwardRule(),
                new JumpDirectionMustBeOverOtherPieceRule(),
                new PiecesCannotBeOutsideTheBoardRule(),
                new PiecesCannotOccupyBlackSquaresRule(),
                new PiecesCannotOccupyTheSameSquareRule(),
                new PiecesCanOnlyJumpTheOtherTeamRule()
        ), new Conditions<>(new WinCondition(), new KingMeCondition()));

        Checkerboard currentState = gameBoard.currentState();

        gameBoard.listenForRules((rule, successful) -> {
            if (!successful) println("FAILED: " + rule.getClass().getSimpleName());
        });

        gameBoard.listenForActions((action, successful) -> {
            if (!successful) print("FAILED: ");
            else print("PASS: ");
            println(action.getClass().getSimpleName());
        });

        while(!currentState.gameOver){
            println(currentState.serialize());
            println("It is " + currentState.currentTurn + "'s turn");
            gameBoard.submitAction(getMove(currentState));
            gameBoard.submitAction(new ChangeTurnAction());
            gameBoard.step();
            currentState = gameBoard.currentState();
        }

        println("And the winner is... " + currentState.winner + "!!!");
        println("Good game!");
    }

    private static Action<Checkerboard> getMove(Checkerboard currentState){
        String idStr;
        int id;
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

        String moveStr;
        while(true){
            println("Enter move (upleft, downleft, upright, downright) [or add 'jump' before of those]: ");
            moveStr = getInput();
            if (moveStr != null){
                if (moveStr.equalsIgnoreCase("upleft")) return new MoveAction(p, MoveDirection.UPLEFT);
                else if (moveStr.equalsIgnoreCase("downleft")) return new MoveAction(p, MoveDirection.DOWNLEFT);
                else if (moveStr.equalsIgnoreCase("upright")) return new MoveAction(p, MoveDirection.UPRIGHT);
                else if (moveStr.equalsIgnoreCase("downright")) return new MoveAction(p, MoveDirection.DOWNRIGHT);
                else if (moveStr.equalsIgnoreCase("jumpupleft")) return new JumpAction(p, MoveDirection.UPLEFT);
                else if (moveStr.equalsIgnoreCase("jumpdownleft")) return new JumpAction(p, MoveDirection.DOWNLEFT);
                else if (moveStr.equalsIgnoreCase("jumpupright")) return new JumpAction(p, MoveDirection.UPRIGHT);
                else if (moveStr.equalsIgnoreCase("jumpdownright")) return new JumpAction(p, MoveDirection.DOWNRIGHT);
            }
            println("Move is not valid, try again");
        }
    }

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String getInput(){
        try {
            String s = br.readLine();
            if (s != null && s.equalsIgnoreCase("q")) System.exit(0);
            return s;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    private static void println(String msg){System.out.println(msg);}
    private static void print(String msg){System.out.print(msg);}
}
