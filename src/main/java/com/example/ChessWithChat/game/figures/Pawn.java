package com.example.ChessWithChat.game.figures;

import com.example.ChessWithChat.game.ChessBoard;
import com.example.ChessWithChat.game.Field;

public class Pawn extends Figure{
    public Pawn(String figureColor, ChessBoard chessBoard) {
        super(figureColor, chessBoard);
    }

    @Override
    public boolean isCanTurn(Field startField, Field finishField, ChessBoard chessBoard, boolean isPawnLastLongMove) {

        if (startField.getFigure().getFigureColor().equals("black")) {
            if(startField.getCoordinates()[0] == 1 &&
                    finishField.getCoordinates()[0] - startField.getCoordinates()[0] == 2 &&
                    finishField.getCoordinates()[1] == startField.getCoordinates()[1] &&
                    chessBoard.isFiguresNoOnTheWayVertical(startField, finishField))
                return true;
            else if (finishField.getCoordinates()[0] - startField.getCoordinates()[0] == 1 &&
                    finishField.getCoordinates()[1] == startField.getCoordinates()[1] &&
                    finishField.getFigure() == null)
                return true;
            else if (finishField.getFigure() != null) {
                return finishField.getFigure().getFigureColor().equals("white") &&
                        Math.abs(finishField.getCoordinates()[1] - startField.getCoordinates()[1]) == 1 &&
                        finishField.getCoordinates()[0] - startField.getCoordinates()[0] == 1;
            } else return finishField.getCoordinates()[0] == 5 &&
                    Math.abs(finishField.getCoordinates()[1] - startField.getCoordinates()[1]) == 1 &&
                    finishField.getCoordinates()[0] - startField.getCoordinates()[0] == 1 &&
                    isPawnLastLongMove;
        }

        else {
            if(startField.getCoordinates()[0] == 6 &&
                    startField.getCoordinates()[0] - finishField.getCoordinates()[0] == 2 &&
                    finishField.getCoordinates()[1] == startField.getCoordinates()[1] &&
                    chessBoard.isFiguresNoOnTheWayVertical(startField, finishField))
                return true;
            else if (startField.getCoordinates()[0] - finishField.getCoordinates()[0] == 1 &&
                    finishField.getCoordinates()[1] == startField.getCoordinates()[1] &&
                    finishField.getFigure() == null)
                return true;
            else if (finishField.getFigure() != null) {
                return finishField.getFigure().getFigureColor().equals("black") &&
                        Math.abs(finishField.getCoordinates()[1] - startField.getCoordinates()[1]) == 1 &&
                        startField.getCoordinates()[0] - finishField.getCoordinates()[0] == 1;
            } else return finishField.getCoordinates()[0] == 2 &&
                    Math.abs(finishField.getCoordinates()[1] - startField.getCoordinates()[1]) == 1 &&
                    startField.getCoordinates()[0] - finishField.getCoordinates()[0] == 1 &&
                    isPawnLastLongMove;
        }
    }

    @Override
    public String toString() {
        return "Pawn";
    }
}
