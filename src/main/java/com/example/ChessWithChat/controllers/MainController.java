package com.example.ChessWithChat.controllers;

import com.example.ChessWithChat.game.Chess;
import com.example.ChessWithChat.game.ChessBoard;
import com.example.ChessWithChat.game.Field;
import com.example.ChessWithChat.models.ImageMy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@Controller
@RequestMapping("/game")
public class MainController {
    private final Chess chess;
    private ImageMy imageMy;
    private int countTaking = 0;
    private String lastTakingName;
    private String finishFieldName;

    @Autowired
    public MainController(Chess chess, ImageMy imageMy) {
        this.chess = chess;
        this.imageMy = imageMy;
    }

    @GetMapping()
    public String mainPage(Model model) {
        model.addAttribute("imageMy", imageMy);
        model.addAttribute("chess", chess);
        return "mainPage";
    }

    @GetMapping("/restart")
    public String restartGame(Model model) {

        chess.setChessBoard(new ChessBoard());
        chess.setWhoTurn("white");
        imageMy = new ImageMy();

        model.addAttribute("imageMy", imageMy);
        model.addAttribute("chess", chess);

        return "mainPage";
    }

    @GetMapping("/turn")
    public String tryTurn(@RequestParam("paramName") String finishFieldName, Model model) {

        countTaking++;

        model.addAttribute("imageMy", imageMy);
        model.addAttribute("chess", chess);

        if (chess.getChessBoard().isFieldNull(finishFieldName) && countTaking % 2 == 1) { // если начальное поле пустое
            countTaking = 0;
            return "mainPage";
        }

        if (countTaking % 2 == 0) {
            if (chess.makeTurn(lastTakingName, finishFieldName, imageMy)) {

                if (chess.isPawnInEndBoard()) {
                    this.finishFieldName = finishFieldName;
                    return "choice figure";
                }

                lastTakingName = null;

            } else {
                countTaking = 0;
            }
        } else {
            lastTakingName = finishFieldName;
        }
        return "mainPage";
    }

    @GetMapping("/choiceFigure")
    public String choiceFigure(Model model) {
        model.addAttribute("imageMy", imageMy);

        return "choice figure";
    }

    @GetMapping("/choiceFigure/choices")
    public String choiceKnight(@RequestParam("paramName") String figureName, Model model) {

        model.addAttribute("imageMy", imageMy);

        chess.changePawn(figureName, finishFieldName, imageMy);

        return "redirect:/game";
    }
}
