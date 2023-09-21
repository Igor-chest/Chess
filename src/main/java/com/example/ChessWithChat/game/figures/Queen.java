package com.example.ChessWithChat.game.figures;

import com.example.ChessWithChat.game.ChessBoard;
import com.example.ChessWithChat.game.Field;

public class Queen extends Figure {
    public Queen(String figureColor, ChessBoard chessBoard) {
        super(figureColor, chessBoard);
    }

    @Override
    public boolean isCanTurn(Field startField, Field finishField, ChessBoard chessBoard, boolean isPawnLastLongMove) {

        if (finishField.getFigure() != null) {
            if (!startField.getFigure().getFigureColor().equals(finishField.getFigure().getFigureColor())) {
                return QueenCanMove(startField, finishField, chessBoard);
            }
            return false;
        }

        return QueenCanMove(startField, finishField, chessBoard);
    }

    private boolean QueenCanMove(Field startField, Field finishField, ChessBoard chessBoard) {
        return (finishField.getCoordinates()[1] == startField.getCoordinates()[1]
                && chessBoard.isFiguresNoOnTheWayVertical(startField, finishField))

                || ((finishField.getCoordinates()[0] == startField.getCoordinates()[0])
                && chessBoard.isFiguresNoOnTheWayHorizontal(startField, finishField))

                || ((Math.abs(finishField.getCoordinates()[1] - startField.getCoordinates()[1]) ==
                        Math.abs(finishField.getCoordinates()[0] - startField.getCoordinates()[0]))
                && chessBoard.isFiguresNoOnTheWayDiagonal(startField, finishField));
    }

    @Override
    public String toString() {
        return "Queen";
    }
}
