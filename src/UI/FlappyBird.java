package UI;

import gameLogic.Game;
import gameLogic.GameScaler;

import javax.swing.*;

/**
 * The type Flappy bird.
 */
public class FlappyBird extends JFrame {
    private Game game;
    private GameScaler gameScaler;
    private ImageIcon gameIcon = new ImageIcon("src/flappyBirdImages/flappyBirdIcon.jpg");

    /**
     * Instantiates a new Flappy bird.
     * Sets needed parameters
     *
     * @param backgroundImageName      the background image name
     * @param birdImageName            the bird image name
     * @param birdFallingImageName     the bird falling image name
     * @param birdSemiFallingImageName the bird semi falling image name
     * @param birdJumpImageName        the bird jump image name
     * @param bottomPipeImageName      the bottom pipe image name
     * @param topPipeImageName         the top pipe image name
     */
    public FlappyBird(String backgroundImageName, String birdImageName, String birdFallingImageName, String birdSemiFallingImageName, String birdJumpImageName, String bottomPipeImageName, String topPipeImageName) {
        game = new Game(this, backgroundImageName, birdImageName, birdFallingImageName, birdSemiFallingImageName, birdJumpImageName, bottomPipeImageName, topPipeImageName);
        add(game);
        setSize(game.getBackgroundWidth(), game.getBackgroundHeight());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);
        setResizable(false);
        setTitle("Flappy Bird");
        setIconImage(gameIcon.getImage());
        gameScaler = new GameScaler(game);
        getGameScaler().resize(this,game,game.getBird());
        getGameScaler().resizeBack(this,game,game.getBird());
        setComponentZOrder(game, 0);
        setVisible(true);
        game.requestFocus();
    }

    /**
     * Gets game scaler.
     *
     * @return the game scaler
     */
    public GameScaler getGameScaler() {
        return gameScaler;
    }

    /**
     * Gets game.
     *
     * @return the game
     */
    public Game getGame() {
        return game;
    }
}
