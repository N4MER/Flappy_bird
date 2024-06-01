package UI;

import gameLogic.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * The type Fullscreen button.
 */
public class FullscreenButton extends MyButtons {
    private InputMap inputMap;
    private ActionMap actionMap;
    private KeyStroke key = KeyStroke.getKeyStroke("F11");
    private boolean resized = false;
    private Action buttonAction;

    /**
     * Instantiates a new Fullscreen button.
     *
     * @param flappyBird the flappy bird
     * @param game       the game
     */
    public FullscreenButton(FlappyBird flappyBird, Game game) {
        super(game);
        buttonAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionAfterPress(flappyBird, game);
            }
        };
        setButtonX(game.getBackgroundWidth() - 20);
        setButtonY(0);
        setButtonWidth(20);
        setButtonHeight(20);
        setBounds(getButtonX(), getButtonY(), getButtonWidth(), getButtonHeight());
        setText("a");
        setInputToAction(key);
        addListener(flappyBird, game);
    }

    @Override
    public void setInputToAction(KeyStroke keyStroke) {
        key = keyStroke;
        inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        actionMap = getActionMap();
        inputMap.put(key, "pressed F11");
        actionMap.put("pressed F11", buttonAction);
    }

    /**
     * Add listener.
     * Calls actionAfterPress if the button is pressed
     * @param flappyBird the flappy bird
     * @param game       the game
     */
    public void addListener(FlappyBird flappyBird, Game game) {
        this.addActionListener(e -> {
            if (e.getSource() == this) {
                actionAfterPress(flappyBird, game);
            }
        });
    }

    /**
     * Action after press.
     * Resizes or reverts to original size depending on resized boolean and sets location of the game to the middle of the screen
     * @param flappyBird the flappy bird
     * @param game       the game
     */
    public void actionAfterPress(FlappyBird flappyBird, Game game) {
        if (game.isAtStartScreen()) {
            if (resized) {
                flappyBird.getGameScaler().resizeBack(flappyBird, game, game.getBird());
                flappyBird.setLocationRelativeTo(null);
                resized = false;
            } else {
                flappyBird.getGameScaler().resize(flappyBird, game, game.getBird());
                flappyBird.setLocation(0, 0);
                resized = true;
            }
        }
    }


}
