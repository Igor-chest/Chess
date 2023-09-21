package com.example.ChessWithChat.game.figures;

import com.example.ChessWithChat.game.ChessBoard;
import com.example.ChessWithChat.game.Field;

public class Knight extends Figure {


    public Knight(String figureColor, ChessBoard chessBoard) {
        super(figureColor, chessBoard);
    }

    @Override
    public boolean isCanTurn(Field startField, Field finishField, ChessBoard chessBoard, boolean isPawnLastLongMove) {

        if (finishField.getFigure() != null) {
            if (!startField.getFigure().getFigureColor().equals(finishField.getFigure().getFigureColor())) {
                return Math.abs(finishField.getCoordinates()[1] - startField.getCoordinates()[1]) +
                        Math.abs(finishField.getCoordinates()[0] - startField.getCoordinates()[0]) == 3;
            }
            return false;
        }

        return Math.abs(finishField.getCoordinates()[1] - startField.getCoordinates()[1]) +
                Math.abs(finishField.getCoordinates()[0] - startField.getCoordinates()[0]) == 3;
    }

    @Override
    public String toString() {
        return "Knight";
    }
}
