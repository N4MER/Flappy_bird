package UI;

import gameLogic.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;

public abstract class MyButtons extends JButton {
    private InputMap inputMap;
    private ActionMap actionMap;
    private KeyStroke key;
    private Action buttonAction;
    private int buttonX = 0;
    private int buttonY = 0;
    private int buttonWidth;
    private int buttonHeight;

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

    public void setInputToAction(KeyStroke keyStroke) {
        key = keyStroke;
        inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        actionMap = getActionMap();
        inputMap.put(key, "pressed space");
        actionMap.put("pressed space", buttonAction);

    }


    public void myAddActionListener(Game game) {
        this.addActionListener(e -> {
            if (e.getSource() == this) {
                performedActionOnPress(game);
            }
        });
    }

    public void performedActionOnPress(Game game) {

    }

    public int getButtonX() {
        return buttonX;
    }

    public void setButtonX(int buttonX) {
        this.buttonX = buttonX;
    }

    public int getButtonY() {
        return buttonY;
    }

    public void setButtonY(int buttonY) {
        this.buttonY = buttonY;
    }

    public int getButtonWidth() {
        return buttonWidth;
    }

    public void setButtonWidth(int buttonWidth) {
        this.buttonWidth = buttonWidth;
    }

    public int getButtonHeight() {
        return buttonHeight;
    }

    public void setButtonHeight(int buttonHeight) {
        this.buttonHeight = buttonHeight;
    }

    public Action getButtonAction() {
        return buttonAction;
    }
}
