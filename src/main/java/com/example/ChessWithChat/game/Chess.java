package com.example.ChessWithChat.game;

import com.example.ChessWithChat.game.figures.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Chess {
    private ChessBoard chessBoard;
    private String whoTurn;
    private boolean isPawnLastLongMove; // последний ход - длинный ход пешкой?
    private int[] coordinatesTakingOnThePass; // координаты взятия на проходе
    private boolean isPawnInEndBoard;

    @Autowired
    public Chess(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
        this.whoTurn = "white";
        this.isPawnLastLongMove = false;
        this.coordinatesTakingOnThePass = new int[]{9, 9};
        this.isPawnInEndBoard = false;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public String getWhoTurn() {
        return whoTurn;
    }

    public void setWhoTurn(String whoTurn) {
        this.whoTurn = whoTurn;
    }

    public boolean isPawnLastLongMove() {
        return isPawnLastLongMove;
    }

    public void setPawnLastLongMove(boolean pawnLastLongMove) {
        isPawnLastLongMove = pawnLastLongMove;
    }

    public int[] getCoordinatesTakingOnThePass() {
        return coordinatesTakingOnThePass;
    }

    public void setCoordinatesTakingOnThePass(int[] coordinatesTakingOnThePass) {
        this.coordinatesTakingOnThePass = coordinatesTakingOnThePass;
    }

    public boolean isPawnInEndBoard() {
        return isPawnInEndBoard;
    }

    public void setPawnInEndBoard(boolean pawnInEndBoard) {
        isPawnInEndBoard = pawnInEndBoard;
    }

    public boolean makeTurn(String startFieldName, String finishFieldName, ImageMy imageMy) {
        Field startField = new Field();
        Field finishField = new Field();


        for (Field[] line: chessBoard.getFields()) {
            for (Field field: line) {
                if (field.getFieldName().equals(startFieldName)) {
                    startField = field;
                }
                if (field.getFieldName().equals(finishFieldName)) {
                    finishField = field;
                }
            }
        }

        if (startField.getFigure() != null &&
                startField.getFigure().isCanTurn(startField, finishField, chessBoard, isPawnLastLongMove) &&
                startField.getFigure().getFigureColor().equals(this.whoTurn)) {

            if (startField.getFigure().toString().equals("King") && // рокировка
                    finishField.getFigure() != null &&
                    finishField.getFigure().toString().equals("Rook") &&
                    startField.getFigure().getFigureColor().equals(finishField.getFigure().getFigureColor())) {
                return makeCastling(startField, finishField, imageMy, chessBoard);
            }

            for (Field[] line: chessBoard.getFields()) {
                for (Field field : line) {
                    if (field.getFieldName().equals(finishFieldName)) {
                        if (isPawnLastLongMove && startField.getFigure().toString().equals("Pawn") && // рубим на проходе
                                finishField.getCoordinates()[0] == coordinatesTakingOnThePass[0] &&
                                finishField.getCoordinates()[1] == coordinatesTakingOnThePass[1]) {
                            if (startField.getFigure().getFigureColor().equals("white")) {
                                chessBoard.getFields()[finishField.getCoordinates()[0]+1][finishField.getCoordinates()[1]].setFigure(null); // убираем срубленную
                                imageMy.getStringFieldsUrls()[finishField.getCoordinates()[0]+1][finishField.getCoordinates()[1]] = imageMy.getUrlEmpty();
                            }
                            else {
                                chessBoard.getFields()[finishField.getCoordinates()[0]-1][finishField.getCoordinates()[1]].setFigure(null); // убираем срубленную
                                imageMy.getStringFieldsUrls()[finishField.getCoordinates()[0]-1][finishField.getCoordinates()[1]] = imageMy.getUrlEmpty();
                            }
                            moveFigure(field, startField, imageMy);
                            isPawnInEndBoard = false;
                            return true;
                        }

                        if (startField.getFigure().toString().equals("Pawn") && // если пешка сходила на 2 - запоминаем это
                                Math.abs(finishField.getCoordinates()[0] - startField.getCoordinates()[0]) == 2) {
                            this.isPawnLastLongMove = true;
                            if (startField.getFigure().getFigureColor().equals("white")) {
                                coordinatesTakingOnThePass[0] = finishField.getCoordinates()[0]+1;
                                coordinatesTakingOnThePass[1] = finishField.getCoordinates()[1];
                            }
                            else {
                                coordinatesTakingOnThePass[0] = finishField.getCoordinates()[0]-1;
                                coordinatesTakingOnThePass[1] = finishField.getCoordinates()[1];
                            }
                            moveFigure(field, startField, imageMy);
                            isPawnInEndBoard = false;
                            return true;
                        }
                        else
                            this.isPawnLastLongMove = false;

                        if (!startField.getFigure().toString().equals("Pawn")) { // ходы всех фигур, кроме пешки и короля
                            moveFigure(field, startField, imageMy);

                            isPawnInEndBoard = false;

                            return true;
                        } else if (Math.abs(finishField.getCoordinates()[0] - startField.getCoordinates()[0]) == 1) { // обычный ход пешки
                            moveFigure(field, startField, imageMy);

                            isPawnInEndBoard = finishField.getCoordinates()[0] == 0 || finishField.getCoordinates()[0] == 7;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean makeCastling(Field kingField, Field rookField, ImageMy imageMy, ChessBoard chessBoard) { // рокировка
        if (rookField.getCoordinates()[1] > kingField.getCoordinates()[1]) {

            chessBoard.getFields()[kingField.getCoordinates()[0]][6].setFigure(kingField.getFigure());
            imageMy.getStringFieldsUrls()[kingField.getCoordinates()[0]][6] =
                    imageMy.getStringFieldsUrls()[kingField.getCoordinates()[0]][kingField.getCoordinates()[1]];

            chessBoard.getFields()[kingField.getCoordinates()[0]][5].setFigure(rookField.getFigure());
            imageMy.getStringFieldsUrls()[kingField.getCoordinates()[0]][5] =
                    imageMy.getStringFieldsUrls()[rookField.getCoordinates()[0]][rookField.getCoordinates()[1]];

            return setNulKing(kingField, rookField, imageMy);
        }

        if (rookField.getCoordinates()[1] < kingField.getCoordinates()[1]) {

            chessBoard.getFields()[kingField.getCoordinates()[0]][2].setFigure(kingField.getFigure());
            imageMy.getStringFieldsUrls()[kingField.getCoordinates()[0]][2] =
                    imageMy.getStringFieldsUrls()[kingField.getCoordinates()[0]][kingField.getCoordinates()[1]];

            chessBoard.getFields()[kingField.getCoordinates()[0]][3].setFigure(rookField.getFigure());
            imageMy.getStringFieldsUrls()[kingField.getCoordinates()[0]][3] =
                    imageMy.getStringFieldsUrls()[rookField.getCoordinates()[0]][rookField.getCoordinates()[1]];

            return setNulKing(kingField, rookField, imageMy);
        }
        return false;
    }

    private boolean setNulKing(Field kingField, Field rookField, ImageMy imageMy) {
        kingField.setFigure(null);
        imageMy.getStringFieldsUrls()[kingField.getCoordinates()[0]][kingField.getCoordinates()[1]] =
                imageMy.getUrlEmpty();

        rookField.setFigure(null);
        imageMy.getStringFieldsUrls()[rookField.getCoordinates()[0]][rookField.getCoordinates()[1]] =
                imageMy.getUrlEmpty();

        passMove();

        return true;
    }

    private void passMove() { // смена очередности
        if (whoTurn.equals("white")) {
            this.setWhoTurn("black");
        }
        else {
            this.setWhoTurn("white");
        }
    }

    private void moveFigure(Field field, Field startField, ImageMy imageMy) { // вспомогательный метод для makeTurn
        field.setFigure(startField.getFigure());
        imageMy.getStringFieldsUrls()[field.getCoordinates()[0]][field.getCoordinates()[1]]
                = imageMy.getStringFieldsUrls()[startField.getCoordinates()[0]][startField.getCoordinates()[1]];

        startField.setFigure(null);
        imageMy.getStringFieldsUrls()[startField.getCoordinates()[0]][startField.getCoordinates()[1]]
                = imageMy.getUrlEmpty();

        passMove();
    }

    public void changePawn(String figureName, String finishFieldName, ImageMy imageMy) { // меняет пешку на выбранную фигуру
        Field finishField = new Field();

        for (Field[] line: chessBoard.getFields()) {
            for (Field field : line) {
                if (field.getFieldName().equals(finishFieldName)) {
                    finishField = field;
                }
            }
        }

        if (finishField.getCoordinates()[0] == 0) {
            switch (figureName) {
                case "Queen":
                    chessBoard.getFields()[finishField.getCoordinates()[0]][finishField.getCoordinates()[1]] =
                            new Field(new Queen("white", chessBoard), finishFieldName,
                                    new int[]{finishField.getCoordinates()[0], finishField.getCoordinates()[1]});
                    imageMy.getStringFieldsUrls()[finishField.getCoordinates()[0]][finishField.getCoordinates()[1]] =
                            imageMy.getUrlQueenWhite();
                    break;
                case "Knight":
                    chessBoard.getFields()[finishField.getCoordinates()[0]][finishField.getCoordinates()[1]] =
                            new Field(new Knight("white", chessBoard), finishFieldName,
                                    new int[]{finishField.getCoordinates()[0], finishField.getCoordinates()[1]});
                    imageMy.getStringFieldsUrls()[finishField.getCoordinates()[0]][finishField.getCoordinates()[1]] =
                            imageMy.getUrlKnightWhite();
                    break;
                case "Bishop":
                    chessBoard.getFields()[finishField.getCoordinates()[0]][finishField.getCoordinates()[1]] =
                            new Field(new Bishop("white", chessBoard), finishFieldName,
                                    new int[]{finishField.getCoordinates()[0], finishField.getCoordinates()[1]});
                    imageMy.getStringFieldsUrls()[finishField.getCoordinates()[0]][finishField.getCoordinates()[1]] =
                            imageMy.getUrlBishopWhite();
                    break;
                case "Rook":
                    chessBoard.getFields()[finishField.getCoordinates()[0]][finishField.getCoordinates()[1]] =
                            new Field(new Rook("white", chessBoard), finishFieldName,
                                    new int[]{finishField.getCoordinates()[0], finishField.getCoordinates()[1]});
                    imageMy.getStringFieldsUrls()[finishField.getCoordinates()[0]][finishField.getCoordinates()[1]] =
                            imageMy.getUrlRookWhite();
                    break;
            }

        }
        else {
            switch (figureName) {
                case "Queen":
                    chessBoard.getFields()[finishField.getCoordinates()[0]][finishField.getCoordinates()[1]] =
                            new Field(new Queen("black", chessBoard), finishFieldName,
                                    new int[]{finishField.getCoordinates()[0], finishField.getCoordinates()[1]});
                    imageMy.getStringFieldsUrls()[finishField.getCoordinates()[0]][finishField.getCoordinates()[1]] =
                            imageMy.getUrlQueenBlack();
                    break;
                case "Knight":
                    chessBoard.getFields()[finishField.getCoordinates()[0]][finishField.getCoordinates()[1]] =
                            new Field(new Knight("black", chessBoard), finishFieldName,
                                    new int[]{finishField.getCoordinates()[0], finishField.getCoordinates()[1]});
                    imageMy.getStringFieldsUrls()[finishField.getCoordinates()[0]][finishField.getCoordinates()[1]] =
                            imageMy.getUrlKnightBlack();
                    break;
                case "Bishop":
                    chessBoard.getFields()[finishField.getCoordinates()[0]][finishField.getCoordinates()[1]] =
                            new Field(new Bishop("black", chessBoard), finishFieldName,
                                    new int[]{finishField.getCoordinates()[0], finishField.getCoordinates()[1]});
                    imageMy.getStringFieldsUrls()[finishField.getCoordinates()[0]][finishField.getCoordinates()[1]] =
                            imageMy.getUrlBishopBlack();
                    break;
                case "Rook":
                    chessBoard.getFields()[finishField.getCoordinates()[0]][finishField.getCoordinates()[1]] =
                            new Field(new Rook("black", chessBoard), finishFieldName,
                                    new int[]{finishField.getCoordinates()[0], finishField.getCoordinates()[1]});
                    imageMy.getStringFieldsUrls()[finishField.getCoordinates()[0]][finishField.getCoordinates()[1]] =
                            imageMy.getUrlRookBlack();
                    break;
            }
        }
        isPawnInEndBoard = false;
    }
}