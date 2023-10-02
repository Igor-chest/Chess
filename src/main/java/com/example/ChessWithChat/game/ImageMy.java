package com.example.ChessWithChat.game;

import org.springframework.stereotype.Component;

@Component
public class ImageMy {
    private String urlEmpty = "/figures/Empty.png";

    private String urlPawnWhite = "/figures/pawn white.png";
    private String urlPawnBlack = "/figures/pawn black.png";

    private String urlBishopWhite = "/figures/bishop white.png";
    private String urlBishopBlack = "/figures/bishop black.png";

    private String urlKingWhite = "/figures/king white.png";
    private String urlKingBlack = "/figures/king black.png";

    private String urlKnightWhite = "/figures/knight white.png";
    private String urlKnightBlack = "/figures/knight black.png";

    private String urlQueenWhite = "/figures/queen white.png";
    private String urlQueenBlack = "/figures/queen black.png";

    private String urlRookWhite = "/figures/rook white.png";
    private String urlRookBlack = "/figures/rook black.png";

    private String[][] stringFieldsUrls;

    public ImageMy() {
        stringFieldsUrls = new String[8][8];
        stringFieldsUrls[0][0] = urlRookBlack;
        stringFieldsUrls[0][1] = urlKnightBlack;
        stringFieldsUrls[0][2] = urlBishopBlack;
        stringFieldsUrls[0][3] = urlQueenBlack;
        stringFieldsUrls[0][4] = urlKingBlack;
        stringFieldsUrls[0][5] = urlBishopBlack;
        stringFieldsUrls[0][6] = urlKnightBlack;
        stringFieldsUrls[0][7] = urlRookBlack;

        stringFieldsUrls[1][0] = urlPawnBlack;
        stringFieldsUrls[1][1] = urlPawnBlack;
        stringFieldsUrls[1][2] = urlPawnBlack;
        stringFieldsUrls[1][3] = urlPawnBlack;
        stringFieldsUrls[1][4] = urlPawnBlack;
        stringFieldsUrls[1][5] = urlPawnBlack;
        stringFieldsUrls[1][6] = urlPawnBlack;
        stringFieldsUrls[1][7] = urlPawnBlack;

        stringFieldsUrls[2][0] = urlEmpty;
        stringFieldsUrls[2][1] = urlEmpty;
        stringFieldsUrls[2][2] = urlEmpty;
        stringFieldsUrls[2][3] = urlEmpty;
        stringFieldsUrls[2][4] = urlEmpty;
        stringFieldsUrls[2][5] = urlEmpty;
        stringFieldsUrls[2][6] = urlEmpty;
        stringFieldsUrls[2][7] = urlEmpty;

        stringFieldsUrls[3][0] = urlEmpty;
        stringFieldsUrls[3][1] = urlEmpty;
        stringFieldsUrls[3][2] = urlEmpty;
        stringFieldsUrls[3][3] = urlEmpty;
        stringFieldsUrls[3][4] = urlEmpty;
        stringFieldsUrls[3][5] = urlEmpty;
        stringFieldsUrls[3][6] = urlEmpty;
        stringFieldsUrls[3][7] = urlEmpty;

        stringFieldsUrls[4][0] = urlEmpty;
        stringFieldsUrls[4][1] = urlEmpty;
        stringFieldsUrls[4][2] = urlEmpty;
        stringFieldsUrls[4][3] = urlEmpty;
        stringFieldsUrls[4][4] = urlEmpty;
        stringFieldsUrls[4][5] = urlEmpty;
        stringFieldsUrls[4][6] = urlEmpty;
        stringFieldsUrls[4][7] = urlEmpty;

        stringFieldsUrls[5][0] = urlEmpty;
        stringFieldsUrls[5][1] = urlEmpty;
        stringFieldsUrls[5][2] = urlEmpty;
        stringFieldsUrls[5][3] = urlEmpty;
        stringFieldsUrls[5][4] = urlEmpty;
        stringFieldsUrls[5][5] = urlEmpty;
        stringFieldsUrls[5][6] = urlEmpty;
        stringFieldsUrls[5][7] = urlEmpty;

        stringFieldsUrls[6][0] = urlPawnWhite;
        stringFieldsUrls[6][1] = urlPawnWhite;
        stringFieldsUrls[6][2] = urlPawnWhite;
        stringFieldsUrls[6][3] = urlPawnWhite;
        stringFieldsUrls[6][4] = urlPawnWhite;
        stringFieldsUrls[6][5] = urlPawnWhite;
        stringFieldsUrls[6][6] = urlPawnWhite;
        stringFieldsUrls[6][7] = urlPawnWhite;

        stringFieldsUrls[7][0] = urlRookWhite;
        stringFieldsUrls[7][1] = urlKnightWhite;
        stringFieldsUrls[7][2] = urlBishopWhite;
        stringFieldsUrls[7][3] = urlQueenWhite;
        stringFieldsUrls[7][4] = urlKingWhite;
        stringFieldsUrls[7][5] = urlBishopWhite;
        stringFieldsUrls[7][6] = urlKnightWhite;
        stringFieldsUrls[7][7] = urlRookWhite;
    }

    public String getUrlEmpty() {
        return urlEmpty;
    }

    public void setUrlEmpty(String urlEmpty) {
        this.urlEmpty = urlEmpty;
    }

    public String getUrlPawnWhite() {
        return urlPawnWhite;
    }

    public void setUrlPawnWhite(String urlPawnWhite) {
        this.urlPawnWhite = urlPawnWhite;
    }

    public String getUrlPawnBlack() {
        return urlPawnBlack;
    }

    public void setUrlPawnBlack(String urlPawnBlack) {
        this.urlPawnBlack = urlPawnBlack;
    }

    public String getUrlBishopWhite() {
        return urlBishopWhite;
    }

    public void setUrlBishopWhite(String urlBishopWhite) {
        this.urlBishopWhite = urlBishopWhite;
    }

    public String getUrlBishopBlack() {
        return urlBishopBlack;
    }

    public void setUrlBishopBlack(String urlBishopBlack) {
        this.urlBishopBlack = urlBishopBlack;
    }

    public String getUrlKingWhite() {
        return urlKingWhite;
    }

    public void setUrlKingWhite(String urlKingWhite) {
        this.urlKingWhite = urlKingWhite;
    }

    public String getUrlKingBlack() {
        return urlKingBlack;
    }

    public void setUrlKingBlack(String urlKingBlack) {
        this.urlKingBlack = urlKingBlack;
    }

    public String getUrlKnightWhite() {
        return urlKnightWhite;
    }

    public void setUrlKnightWhite(String urlKnightWhite) {
        this.urlKnightWhite = urlKnightWhite;
    }

    public String getUrlKnightBlack() {
        return urlKnightBlack;
    }

    public void setUrlKnightBlack(String urlKnightBlack) {
        this.urlKnightBlack = urlKnightBlack;
    }

    public String getUrlQueenWhite() {
        return urlQueenWhite;
    }

    public void setUrlQueenWhite(String urlQueenWhite) {
        this.urlQueenWhite = urlQueenWhite;
    }

    public String getUrlQueenBlack() {
        return urlQueenBlack;
    }

    public void setUrlQueenBlack(String urlQueenBlack) {
        this.urlQueenBlack = urlQueenBlack;
    }

    public String getUrlRookWhite() {
        return urlRookWhite;
    }

    public void setUrlRookWhite(String urlRookWhite) {
        this.urlRookWhite = urlRookWhite;
    }

    public String getUrlRookBlack() {
        return urlRookBlack;
    }

    public void setUrlRookBlack(String urlRookBlack) {
        this.urlRookBlack = urlRookBlack;
    }

    public String[][] getStringFieldsUrls() {
        return stringFieldsUrls;
    }

    public void setStringFieldsUrls(String[][] stringFieldsUrls) {
        this.stringFieldsUrls = stringFieldsUrls;
    }
}
