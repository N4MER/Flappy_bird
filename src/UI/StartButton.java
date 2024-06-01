package UI;

import UI.MyButtons;
import gameLogic.Game;

import javax.swing.*;
import java.awt.*;

/**
 * The type Start button.
 */
public class StartButton extends MyButtons {
    /**
     * Instantiates a new Start button.
     *
     * @param game the game
     */
    public StartButton(Game game) {
        super(game);
        setText("Press to start");
        setFont(new Font("Arial",Font.PLAIN,50));
        setInputToAction(KeyStroke.getKeyStroke("SPACE"));

    }
    @Override
    public void performedActionOnPress(Game game) {
        game.startGame();
    }



}

