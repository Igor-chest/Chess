package com.example.ChessWithChat.game.figures;

import com.example.ChessWithChat.game.ChessBoard;
import com.example.ChessWithChat.game.Field;

public class Rook extends Figure {
    private int countTurn;

    public Rook(String figureColor, ChessBoard chessBoard) {
        super(figureColor, chessBoard);
        this.countTurn = 0;
    }

    @Override
    public boolean isCanTurn(Field startField, Field finishField, ChessBoard chessBoard, boolean isPawnLastLongMove) {
        if (finishField.getFigure() != null) {
            if (!startField.getFigure().getFigureColor().equals(finishField.getFigure().getFigureColor())) {
                return RookCanMove(startField, finishField, chessBoard);
            }
            return false;
        }

        return RookCanMove(startField, finishField, chessBoard);
    }

    private boolean RookCanMove(Field startField, Field finishField, ChessBoard chessBoard) {
        if (finishField.getCoordinates()[1] == startField.getCoordinates()[1]
                && chessBoard.isFiguresNoOnTheWayVertical(startField, finishField)

                || ((finishField.getCoordinates()[0] == startField.getCoordinates()[0])
                && chessBoard.isFiguresNoOnTheWayHorizontal(startField, finishField))) {
            countTurn++;
            return true;
        }
        return false;
    }

    public int getCountTurn() {
        return countTurn;
    }

    public void setCountTurn(int countTurn) {
        this.countTurn = countTurn;
    }

    @Override
    public String toString() {
        return "Rook";
    }
}
