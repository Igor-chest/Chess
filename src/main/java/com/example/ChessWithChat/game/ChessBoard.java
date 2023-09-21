package com.example.ChessWithChat.game;

import com.example.ChessWithChat.game.figures.*;
import org.springframework.stereotype.Component;

@Component
public class ChessBoard {
    private Field[][] fields;

    public ChessBoard() {
        fields = new Field[8][8];

        fields[0][0] = new Field(new Rook("black", this), "a8", new int[] {0, 0});
        fields[0][1] = new Field(new Knight("black", this), "b8", new int[] {0, 1});
        fields[0][2] = new Field(new Bishop("black", this), "c8", new int[] {0, 2});
        fields[0][3] = new Field(new Queen("black", this), "d8", new int[] {0, 3});
        fields[0][4] = new Field(new King("black", this), "e8", new int[] {0, 4});
        fields[0][5] = new Field(new Bishop("black", this), "f8", new int[] {0, 5});
        fields[0][6] = new Field(new Knight("black", this), "g8", new int[] {0, 6});
        fields[0][7] = new Field(new Rook("black", this), "h8", new int[] {0, 7});

        fields[1][0] = new Field(new Pawn("black", this), "a7", new int[] {1, 0});
        fields[1][1] = new Field(new Pawn("black", this), "b7", new int[] {1, 1});
        fields[1][2] = new Field(new Pawn("black", this), "c7", new int[] {1, 2});
        fields[1][3] = new Field(new Pawn("black", this), "d7", new int[] {1, 3});
        fields[1][4] = new Field(new Pawn("black", this), "e7", new int[] {1, 4});
        fields[1][5] = new Field(new Pawn("black", this), "f7", new int[] {1, 5});
        fields[1][6] = new Field(new Pawn("black", this), "g7", new int[] {1, 6});
        fields[1][7] = new Field(new Pawn("black", this), "h7", new int[] {1, 7});

        fields[2][0] = new Field(null, "a6", new int[] {2, 0});
        fields[2][1] = new Field(null, "b6", new int[] {2, 1});
        fields[2][2] = new Field(null, "c6", new int[] {2, 2});
        fields[2][3] = new Field(null, "d6", new int[] {2, 3});
        fields[2][4] = new Field(null, "e6", new int[] {2, 4});
        fields[2][5] = new Field(null, "f6", new int[] {2, 5});
        fields[2][6] = new Field(null, "g6", new int[] {2, 6});
        fields[2][7] = new Field(null, "h6", new int[] {2, 7});

        fields[3][0] = new Field(null, "a5", new int[] {3, 0});
        fields[3][1] = new Field(null, "b5", new int[] {3, 1});
        fields[3][2] = new Field(null, "c5", new int[] {3, 2});
        fields[3][3] = new Field(null, "d5", new int[] {3, 3});
        fields[3][4] = new Field(null, "e5", new int[] {3, 4});
        fields[3][5] = new Field(null, "f5", new int[] {3, 5});
        fields[3][6] = new Field(null, "g5", new int[] {3, 6});
        fields[3][7] = new Field(null, "h5", new int[] {3, 7});

        fields[4][0] = new Field(null, "a4", new int[] {4, 0});
        fields[4][1] = new Field(null, "b4", new int[] {4, 1});
        fields[4][2] = new Field(null, "c4", new int[] {4, 2});
        fields[4][3] = new Field(null, "d4", new int[] {4, 3});
        fields[4][4] = new Field(null, "e4", new int[] {4, 4});
        fields[4][5] = new Field(null, "f4", new int[] {4, 5});
        fields[4][6] = new Field(null, "g4", new int[] {4, 6});
        fields[4][7] = new Field(null, "h4", new int[] {4, 7});

        fields[5][0] = new Field(null, "a3", new int[] {5, 0});
        fields[5][1] = new Field(null, "b3", new int[] {5, 1});
        fields[5][2] = new Field(null, "c3", new int[] {5, 2});
        fields[5][3] = new Field(null, "d3", new int[] {5, 3});
        fields[5][4] = new Field(null, "e3", new int[] {5, 4});
        fields[5][5] = new Field(null, "f3", new int[] {5, 5});
        fields[5][6] = new Field(null, "g3", new int[] {5, 6});
        fields[5][7] = new Field(null, "h3", new int[] {5, 7});

        fields[6][0] = new Field(new Pawn("white", this), "a2", new int[] {6, 0});
        fields[6][1] = new Field(new Pawn("white", this), "b2", new int[] {6, 1});
        fields[6][2] = new Field(new Pawn("white", this), "c2", new int[] {6, 2});
        fields[6][3] = new Field(new Pawn("white", this), "d2", new int[] {6, 3});
        fields[6][4] = new Field(new Pawn("white", this), "e2", new int[] {6, 4});
        fields[6][5] = new Field(new Pawn("white", this), "f2", new int[] {6, 5});
        fields[6][6] = new Field(new Pawn("white", this), "g2", new int[] {6, 6});
        fields[6][7] = new Field(new Pawn("white", this), "h2", new int[] {6, 7});

        fields[7][0] = new Field(new Rook("white", this), "a1", new int[] {7, 0});
        fields[7][1] = new Field(new Knight("white", this), "b1", new int[] {7, 1});
        fields[7][2] = new Field(new Bishop("white", this), "c1", new int[] {7, 2});
        fields[7][3] = new Field(new Queen("white", this), "d1", new int[] {7, 3});
        fields[7][4] = new Field(new King("white", this), "e1", new int[] {7, 4});
        fields[7][5] = new Field(new Bishop("white", this), "f1", new int[] {7, 5});
        fields[7][6] = new Field(new Knight("white", this), "g1", new int[] {7, 6});
        fields[7][7] = new Field(new Rook("white", this), "h1", new int[] {7, 7});

    }

    public boolean isFiguresNoOnTheWayVertical(Field startField, Field finishField) {

        if (Math.abs(startField.getCoordinates()[0] - finishField.getCoordinates()[0]) <= 1) { // если старт и финиш стоят вплотную
            return true;
        }

        if (startField.getCoordinates()[0] < finishField.getCoordinates()[0]) {
            for (int i = startField.getCoordinates()[0]+1; i < finishField.getCoordinates()[0]; i++) {
                if (!isFieldNull(fields[i][startField.getCoordinates()[1]].getFieldName())) { // нашли фигуру на пути
                    return false;
                }
            }
            return true;
        } else {
            for (int i = startField.getCoordinates()[0]-1; i > finishField.getCoordinates()[0]; i--) {
                if (!isFieldNull(fields[i][startField.getCoordinates()[1]].getFieldName())) { // нашли фигуру на пути
                    return false;
                }
            }
        }
        return true;

    }

    public boolean isFiguresNoOnTheWayHorizontal(Field startField, Field finishField) {

        if (Math.abs(startField.getCoordinates()[1] - finishField.getCoordinates()[1]) <= 1) { // если старт и финиш стоят вплотную
            return true;
        }

        if (startField.getCoordinates()[1] < finishField.getCoordinates()[1]) {
            for (int i = startField.getCoordinates()[1]+1; i < finishField.getCoordinates()[1]; i++) {
                if (!isFieldNull(fields[startField.getCoordinates()[0]][i].getFieldName())) { // нашли фигуру на пути
                    return false;
                }
            }
            return true;
        } else {
            for (int i = startField.getCoordinates()[1]-1; i > finishField.getCoordinates()[1]; i--) {
                if (!isFieldNull(fields[startField.getCoordinates()[0]][i].getFieldName())) { // нашли фигуру на пути
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isFiguresNoOnTheWayDiagonal(Field startField, Field finishField) {
        int countCheck = 0;

        if (Math.abs(startField.getCoordinates()[0] - finishField.getCoordinates()[0]) <= 1) { // если старт и финиш стоят вплотную
            return true;
        }

        if (startField.getCoordinates()[1] < finishField.getCoordinates()[1]) {
            for (int i = startField.getCoordinates()[1]+1; i < finishField.getCoordinates()[1]; i++) {
                countCheck++;
                if (startField.getCoordinates()[0] < finishField.getCoordinates()[0]) {
                    if (!isFieldNull(fields[startField.getCoordinates()[0]+countCheck][i].getFieldName())) { // нашли фигуру на пути
                        return false;
                    }
                    continue;
                }
                if (!isFieldNull(fields[startField.getCoordinates()[0]-countCheck][i].getFieldName())) { // нашли фигуру на пути
                    return false;
                }
            }
            return true;
        } else {
            for (int i = startField.getCoordinates()[1]-1; i > finishField.getCoordinates()[1]; i--) {
                countCheck++;
                if (startField.getCoordinates()[0] < finishField.getCoordinates()[0]) {
                    if (!isFieldNull(fields[startField.getCoordinates()[0]+countCheck][i].getFieldName())) { // нашли фигуру на пути
                        return false;
                    }
                    continue;
                }
                if (!isFieldNull(fields[startField.getCoordinates()[0]-countCheck][i].getFieldName())) { // нашли фигуру на пути
                    return false;
                }
            }
        }

        return true;

//        (Math.abs(finishField.getCoordinates()[1] - startField.getCoordinates()[1]) ==
//                Math.abs(finishField.getCoordinates()[0] - startField.getCoordinates()[0]))
    }

    public boolean isFieldNull(String fieldName) {
        for (Field[] line: fields) {
            for (Field field: line) {
                if (field.getFieldName().equals(fieldName)) {
                    if (field.getFigure() == null) {
                        return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }

    public Field[][] getFields() {
        return fields;
    }

    public void setFields(Field[][] fields) {
        this.fields = fields;
    }

}
