package UI;

import gameLogic.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * The type Close button.
 */
public class CloseButton extends MyButtons {
    private InputMap inputMap;
    private ActionMap actionMap;
    private KeyStroke key = KeyStroke.getKeyStroke("ESCAPE");

    /**
     * Instantiates a new Close button.
     *
     * @param game the game
     */
    public CloseButton(Game game) {
        super(game);
        setText("x");
        setButtonX(game.getBackgroundWidth());
        setButtonY(0);
        setButtonWidth(20);
        setButtonHeight(20);
        setBounds(getButtonX(), getButtonY(), getButtonWidth(), getButtonHeight());
        setInputToAction(key);
    }
    @Override
    public void setInputToAction(KeyStroke keyStroke) {
        key = keyStroke;
        inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        actionMap = getActionMap();
        inputMap.put(key, "pressed escape");
        actionMap.put("pressed escape", getButtonAction());
    }

    @Override
    public void performedActionOnPress(Game game) {
        System.exit(0);
    }
}
