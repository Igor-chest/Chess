package com.example.ChessWithChat.game;

import com.example.ChessWithChat.game.figures.Figure;

public class Field {
    private Figure figure;
    private String fieldName;
    private int[] coordinates;

    public Field() {
    }

    public Field(Figure figure, String fieldName, int[] coordinates) {
        this.figure = figure;
        this.fieldName = fieldName;
        this.coordinates = coordinates;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }
}
