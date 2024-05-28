import javax.swing.*;
import java.awt.*;

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


    public GameScaler(Game game) {
        this.backgroundImage = game.getBackgroundImage().getImage();
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;
        baseScreenWidth = game.getBackgroundWidth();
        baseScreenHeight = game.getBackgroundHeight();
    }

    public void resize(FlappyBird flappyBird, Game game, Bird bird) {
        calculateResizeValue();
        createResizedImages();
        resizeWindow(flappyBird, game);
        increaseOtherParameters(game, bird);
        resizeButtons(game);
    }

    public void resizeBack(FlappyBird flappyBird, Game game, Bird bird) {
        resizeWindowBack(flappyBird, game);
        decreaseOtherParameters(game, bird);
        resizeButtonsBack(game);
    }

    public void calculateResizeValue() {
        widthResizeValue = screenWidth / baseScreenWidth;
        heightResizeValue = screenHeight / baseScreenHeight;

    }

    public void createResizedImages() {
        newBackgroundImage = backgroundImage.getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
    }

    public void increaseOtherParameters(Game game, Bird bird) {
        game.setBaseGameSpeed(game.getBaseGameSpeed() * widthResizeValue);
        game.setGameSpeedIncreaseSize(game.getGameSpeedIncreaseSize() * widthResizeValue);
        game.setPipeDifficulty(game.getPipeDifficulty() * heightResizeValue);
        game.setPipeGap(game.getPipeGap() * heightResizeValue);
        bird.setGravity(bird.getGravity() * heightResizeValue);
        bird.setBirdBaseSpeed(bird.getBirdBaseSpeed() * heightResizeValue);
        bird.setJumpForce(bird.getJumpForce() * heightResizeValue);
        game.setPipeMaxY(screenHeight-game.getPipeDifficulty());
    }
    public void decreaseOtherParameters(Game game, Bird bird) {
        game.setBaseGameSpeed(game.getBaseGameSpeed() / widthResizeValue);
        game.setGameSpeedIncreaseSize(game.getGameSpeedIncreaseSize() / widthResizeValue);
        game.setPipeDifficulty(game.getPipeDifficulty() / heightResizeValue);
        game.setPipeGap(game.getPipeGap() / heightResizeValue);
        bird.setGravity(bird.getGravity() / heightResizeValue);
        bird.setBirdBaseSpeed(bird.getBirdBaseSpeed() / heightResizeValue);
        bird.setJumpForce(bird.getJumpForce() / heightResizeValue);
        game.setPipeMaxY(baseScreenHeight-game.getPipeDifficulty());
    }

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

    public void resizeWindow(FlappyBird flappyBird, Game game) {
        game.setBackgroundImage(new ImageIcon(newBackgroundImage));
        flappyBird.setSize(screenSize);
    }

    public void resizeWindowBack(FlappyBird flappyBird, Game game) {
        game.setBackgroundImage(new ImageIcon(backgroundImage));
        flappyBird.setSize(game.getBackgroundWidth(), game.getBackgroundHeight());
    }


}
