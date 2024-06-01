package UI;

import UI.MyButtons;
import gameLogic.Game;

import javax.swing.*;
import java.awt.*;

/**
 * The type Reset button.
 */
public class ResetButton extends MyButtons {
    /**
     * Instantiates a new Reset button.
     *
     * @param game the game
     */
    public ResetButton(Game game) {
        super(game);
        setText("Press to restart");
        setFont(new Font("Arial",Font.PLAIN,50));
        setInputToAction(KeyStroke.getKeyStroke("SPACE"));
    }

    @Override
    public void performedActionOnPress(Game game) {
        game.resetGame();
    }
}
