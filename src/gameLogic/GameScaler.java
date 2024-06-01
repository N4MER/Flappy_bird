package gameLogic;
import UI.FlappyBird;
import entities.Bird;


import javax.swing.*;
import java.awt.*;

/**
 * The type Game scaler.
 */
public class GameScaler {
    private Image backgroundImage;
    private Image newBackgroundImage;
    private int screenWidth;
    private int screenHeight;
    private int baseScreenWidth;
    private int baseScreenHeight;
    private int widthResizeValue = 1;
    private int heightResizeValue = 1;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


    /**
     * Instantiates a new Game scaler.
     *
     * @param game the game
     */
    public GameScaler(Game game) {
        this.backgroundImage = game.getBackgroundImage().getImage();
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;
        baseScreenWidth = game.getBackgroundWidth();
        baseScreenHeight = game.getBackgroundHeight();
    }

    /**
     * Resize.
     * Resizes everything.
     * @param flappyBird the flappy bird
     * @param game       the game
     * @param bird       the bird
     */
    public void resize(FlappyBird flappyBird, Game game, Bird bird) {
        calculateResizeValue();
        createResizedImages();
        resizeWindow(flappyBird, game);
        increaseOtherParameters(game, bird);
        resizeButtons(game);
    }

    /**
     * Resize back.
     * Resizes everything back.
     * @param flappyBird the flappy bird
     * @param game       the game
     * @param bird       the bird
     */
    public void resizeBack(FlappyBird flappyBird, Game game, Bird bird) {
        resizeWindowBack(flappyBird, game);
        decreaseOtherParameters(game, bird);
        resizeButtonsBack(game);
    }

    /**
     * Calculate resize value.
     * Calculates by how much were width and height increased
     */
    public void calculateResizeValue() {
        widthResizeValue = screenWidth / baseScreenWidth;
        heightResizeValue = screenHeight / baseScreenHeight;

    }

    /**
     * Create resized images.
     * Creates resized image for background.
     */
    public void createResizedImages() {
        newBackgroundImage = backgroundImage.getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
    }

    /**
     * Increase other parameters.
     * Increases necessary parameters for gameplay.
     * @param game the game
     * @param bird the bird
     */
    public void increaseOtherParameters(Game game, Bird bird) {
        game.setBaseGameSpeed(game.getBaseGameSpeed() * widthResizeValue);
        game.setGameSpeedIncreaseSize(game.getGameSpeedIncreaseSize() * widthResizeValue);
        game.setPipeDifficulty(game.getPipeDifficulty() * heightResizeValue);
        game.setPipeGap(game.getPipeGap() * heightResizeValue);
        bird.setGravity(bird.getGravity() * heightResizeValue);
        bird.setBirdBaseSpeed(bird.getBirdBaseSpeed() * heightResizeValue);
        bird.setJumpForce(bird.getJumpForce() * heightResizeValue);
        game.setPipeMaxY(screenHeight-game.getPipeDifficulty());
        bird.setBirdY(game.getBackgroundHeight()/2 + bird.getBirdHeight());
        bird.setBirdX(game.getBackgroundWidth()/8);
    }

    /**
     * Decrease other parameters.
     * Decreases necessary parameters for gameplay.
     * @param game the game
     * @param bird the bird
     */
    public void decreaseOtherParameters(Game game, Bird bird) {
        game.setBaseGameSpeed(game.getBaseGameSpeed() / widthResizeValue);
        game.setGameSpeedIncreaseSize(game.getGameSpeedIncreaseSize() / widthResizeValue);
        game.setPipeDifficulty(game.getPipeDifficulty() / heightResizeValue);
        game.setPipeGap(game.getPipeGap() / heightResizeValue);
        bird.setGravity(bird.getGravity() / heightResizeValue);
        bird.setBirdBaseSpeed(bird.getBirdBaseSpeed() / heightResizeValue);
        bird.setJumpForce(bird.getJumpForce() / heightResizeValue);
        game.setPipeMaxY(baseScreenHeight-game.getPipeDifficulty());
        bird.setBirdY(game.getBackgroundHeight()/2 + bird.getBirdHeight());
        bird.setBirdX(game.getBackgroundWidth()/8);
    }

    /**
     * Resize buttons.
     * Resize buttons and puts them in correct location.
     * @param game the game
     */
    public void resizeButtons(Game game) {
        game.getStartButton().setSize(screenSize);
        game.getResetButton().setSize(screenSize);
        game.getCloseButton().setSize( game.getCloseButton().getWidth() * widthResizeValue, game.getCloseButton().getButtonHeight() * heightResizeValue);
        game.getFullscreenButton().setSize( game.getFullscreenButton().getWidth() * widthResizeValue, game.getFullscreenButton().getButtonHeight() * heightResizeValue);
        game.getStartButton().setLocation(0, 0);
        game.getResetButton().setLocation(0, 0);
        game.getCloseButton().setLocation(game.getBackgroundWidth() - game.getCloseButton().getWidth(), 0);
        game.getFullscreenButton().setLocation(game.getBackgroundWidth() - game.getCloseButton().getWidth() - game.getFullscreenButton().getWidth(), 0);
    }

    /**
     * Resize buttons back.
     * Resize buttons back and puts them in correct location.
     * @param game the game
     */
    public void resizeButtonsBack(Game game) {
        game.getStartButton().setSize(baseScreenWidth,baseScreenHeight);
        game.getResetButton().setSize(baseScreenWidth,baseScreenHeight);
        game.getCloseButton().setSize(game.getCloseButton().getWidth() / widthResizeValue, game.getCloseButton().getButtonHeight() / heightResizeValue);
        game.getFullscreenButton().setSize(game.getFullscreenButton().getWidth() / widthResizeValue, game.getFullscreenButton().getButtonHeight() / heightResizeValue);
        game.getStartButton().setLocation(0, 0);
        game.getResetButton().setLocation(0, 0);
        game.getCloseButton().setLocation(game.getBackgroundWidth() - game.getCloseButton().getWidth(), 0);
        game.getFullscreenButton().setLocation(game.getBackgroundWidth() - game.getCloseButton().getWidth() - game.getFullscreenButton().getWidth(), 0);

    }

    /**
     * Resize window.
     * Resizes main jFrame.
     * @param flappyBird the flappy bird
     * @param game       the game
     */
    public void resizeWindow(FlappyBird flappyBird, Game game) {
        game.setBackgroundImage(new ImageIcon(newBackgroundImage));
        flappyBird.setSize(screenSize);
    }

    /**
     * Resize window back.
     * Resizes main jFrame back.
     * @param flappyBird the flappy bird
     * @param game       the game
     */
    public void resizeWindowBack(FlappyBird flappyBird, Game game) {
        game.setBackgroundImage(new ImageIcon(backgroundImage));
        flappyBird.setSize(game.getBackgroundWidth(), game.getBackgroundHeight());
    }


}
