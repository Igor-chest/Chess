package com.example.ChessWithChat.game.figures;

import com.example.ChessWithChat.game.ChessBoard;
import com.example.ChessWithChat.game.Field;

public class King extends Figure {
    private int countTurn;

    public King(String figureColor, ChessBoard chessBoard) {
        super(figureColor, chessBoard);
        this.countTurn = 0;
    }

    @Override
    public boolean isCanTurn(Field startField, Field finishField, ChessBoard chessBoard, boolean isPawnLastLongMove) {

        if (finishField.getFigure() != null) {
            if (!startField.getFigure().getFigureColor().equals(finishField.getFigure().getFigureColor())) {
                if (Math.abs(finishField.getCoordinates()[1] - startField.getCoordinates()[1]) <= 1 &&
                        Math.abs(finishField.getCoordinates()[0] - startField.getCoordinates()[0]) <= 1) {
                    countTurn++;
                    return true;
                }
            }
            else if (finishField.getFigure().toString().equals("Rook") &&
                    finishField.getFigure().getFigureColor().equals(startField.getFigure().getFigureColor()) &&
                    countTurn == 0 && finishField.getFigure().getCountTurn() == 0 &&
                    chessBoard.isFiguresNoOnTheWayHorizontal(startField, finishField)) {
                countTurn++;
                return true;
            }
            return false;
        }
        if (Math.abs(finishField.getCoordinates()[1] - startField.getCoordinates()[1]) <= 1 &&
                Math.abs(finishField.getCoordinates()[0] - startField.getCoordinates()[0]) <= 1) {
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
        return "King";
    }
}
