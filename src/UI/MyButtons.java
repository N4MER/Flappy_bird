package UI;

import gameLogic.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * The type My buttons.
 */
public abstract class MyButtons extends JButton {
    private InputMap inputMap;
    private ActionMap actionMap;
    private KeyStroke key;
    private Action buttonAction;
    private int buttonX = 0;
    private int buttonY = 0;
    private int buttonWidth;
    private int buttonHeight;

    /**
     * Instantiates a new My buttons.
     *
     * @param game the game
     */
    public MyButtons(Game game) {
        buttonWidth = game.getBackgroundWidth();
        buttonHeight = game.getBackgroundHeight();
        setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusable(false);
        buttonAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performedActionOnPress(game);
            }
        };
        myAddActionListener(game);
    }

    /**
     * Sets input to action.
     * Binds an action to a keystroke.
     * @param keyStroke the keystroke
     */
    public void setInputToAction(KeyStroke keyStroke) {
        key = keyStroke;
        inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        actionMap = getActionMap();
        inputMap.put(key, "pressed space");
        actionMap.put("pressed space", buttonAction);

    }


    /**
     * My add action listener.
     * Adds an action listener that uses performedActionOnPress after clicking the button.
     * @param game the game
     */
    public void myAddActionListener(Game game) {
        this.addActionListener(e -> {
            if (e.getSource() == this) {
                performedActionOnPress(game);
            }
        });
    }

    /**
     * Performed action on press.
     *
     * @param game the game
     */
    public void performedActionOnPress(Game game) {

    }

    /**
     * Gets button x.
     *
     * @return the button x
     */
    public int getButtonX() {
        return buttonX;
    }

    /**
     * Sets button x.
     *
     * @param buttonX the button x
     */
    public void setButtonX(int buttonX) {
        this.buttonX = buttonX;
    }

    /**
     * Gets button y.
     *
     * @return the button y
     */
    public int getButtonY() {
        return buttonY;
    }

    /**
     * Sets button y.
     *
     * @param buttonY the button y
     */
    public void setButtonY(int buttonY) {
        this.buttonY = buttonY;
    }

    /**
     * Gets button width.
     *
     * @return the button width
     */
    public int getButtonWidth() {
        return buttonWidth;
    }

    /**
     * Sets button width.
     *
     * @param buttonWidth the button width
     */
    public void setButtonWidth(int buttonWidth) {
        this.buttonWidth = buttonWidth;
    }

    /**
     * Gets button height.
     *
     * @return the button height
     */
    public int getButtonHeight() {
        return buttonHeight;
    }

    /**
     * Sets button height.
     *
     * @param buttonHeight the button height
     */
    public void setButtonHeight(int buttonHeight) {
        this.buttonHeight = buttonHeight;
    }

    /**
     * Gets button action.
     *
     * @return the button action
     */
    public Action getButtonAction() {
        return buttonAction;
    }
}
