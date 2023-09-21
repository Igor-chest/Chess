package com.example.ChessWithChat.game.figures;

import com.example.ChessWithChat.game.ChessBoard;
import com.example.ChessWithChat.game.Field;

public class Figure {
    private String figureColor;
    private ChessBoard chessBoard;
    private int countTurn;

    public Figure(String figureColor, ChessBoard chessBoard) {
        this.figureColor = figureColor;
        this.chessBoard = chessBoard;
    }

    public String getFigureColor() {
        return figureColor;
    }

    public void setFigureColor(String figureColor) {
        this.figureColor = figureColor;
    }

    public int getCountTurn() {
        return countTurn;
    }

    public void setCountTurn(int countTurn) {
        this.countTurn = countTurn;
    }

    public boolean isCanTurn(Field startField, Field finishField, ChessBoard chessBoard, boolean isPawnLastLongMove) {
        return false;
    }
}
