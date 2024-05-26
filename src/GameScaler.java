import javax.swing.*;
import java.awt.*;

public class GameScaler {
    /*private Image normalBirdImage;
    private Image birdFallingImage;
    private Image birdSemiFallingImage;
    private Image birdJumpImage;*/

    /*private Image bottomPipeImage;
    private Image topPipeImage;
    private Image newNormalBirdImage;
    private Image newBirdFallingImage;
    private Image newBirdSemiFallingImage;
    private Image newBirdJumpImage;*/
    private Image backgroundImage;
    private Image newBackgroundImage;
    /*private Image newBottomPipeImage;
    private Image newTopPipeImage;*/
    private int screenWidth;
    private int screenHeight;
    private int baseScreenWidth;
    private int baseScreenHeight;
    private int widthResizeValue = 1;
    private int heightResizeValue = 1;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


    public GameScaler(Game game, Bird bird) {
        /*this.normalBirdImage = bird.getNormalBirdImage().getImage();
        this.birdFallingImage = bird.getBirdFallingImage().getImage();
        this.birdSemiFallingImage = bird.getBirdSemiFallingImage().getImage();
        this.birdJumpImage = bird.getBirdJumpImage().getImage();
        this.bottomPipeImage = game.getBottomPipeImage().getImage();
        this.topPipeImage = game.getTopPipeImage().getImage();*/
        this.backgroundImage = game.getBackgroundImage().getImage();
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;
        baseScreenWidth = game.getBackgroundWidth();
        baseScreenHeight = game.getBackgroundHeight();
    }

    public void resize(FlappyBird flappyBird, Game game, Bird bird) {
        calculateResizeValue();
        createResizedImages();
        resizeWindow(flappyBird, game, bird);
        increaseOtherSize(game, bird);
        resizeButtons(game);
    }

    public void resizeBack(FlappyBird flappyBird, Game game, Bird bird) {
        resizeWindowBack(flappyBird, game, bird);
        decreaseOtherSize(game, bird);
        resizeButtonsBack(game);
    }

    public void calculateResizeValue() {
        widthResizeValue = screenWidth / baseScreenWidth;
        heightResizeValue = screenHeight / baseScreenHeight;

    }

    public void createResizedImages() {
        /*newNormalBirdImage = normalBirdImage.getScaledInstance(normalBirdImage.getWidth(null) * widthResizeValue, normalBirdImage.getHeight(null) * heightResizeValue, Image.SCALE_SMOOTH);
        newBirdFallingImage = birdFallingImage.getScaledInstance(birdFallingImage.getWidth(null) * widthResizeValue, birdFallingImage.getHeight(null) * heightResizeValue, Image.SCALE_SMOOTH);
        newBirdSemiFallingImage = birdSemiFallingImage.getScaledInstance(birdFallingImage.getWidth(null) * widthResizeValue, birdFallingImage.getHeight(null) * heightResizeValue, Image.SCALE_SMOOTH);
        newBirdJumpImage = birdJumpImage.getScaledInstance(birdJumpImage.getWidth(null) * widthResizeValue, birdJumpImage.getHeight(null) * heightResizeValue, Image.SCALE_SMOOTH);*/
        newBackgroundImage = backgroundImage.getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
        /*newBottomPipeImage = bottomPipeImage.getScaledInstance(bottomPipeImage.getWidth(null) * widthResizeValue, bottomPipeImage.getHeight(null), Image.SCALE_SMOOTH);
        newTopPipeImage = topPipeImage.getScaledInstance(bottomPipeImage.getWidth(null) * widthResizeValue, bottomPipeImage.getHeight(null), Image.SCALE_SMOOTH);*/
    }

    public void increaseOtherSize(Game game, Bird bird) {
        game.setBaseGameSpeed(game.getBaseGameSpeed() * widthResizeValue);
        game.setGameSpeedIncreaseSize(game.getGameSpeedIncreaseSize() * widthResizeValue);
        game.setPipeDifficulty(game.getPipeDifficulty() * heightResizeValue);
        game.setPipeGap(game.getPipeGap() * heightResizeValue);
        /*bird.setBirdHeight(bird.getBirdHeight() * heightResizeValue);
        bird.setBirdWidth(bird.getBirdWidth() * widthResizeValue);*/
        bird.setGravity(bird.getGravity() * heightResizeValue);
        bird.setBirdBaseSpeed(bird.getBirdBaseSpeed() * heightResizeValue);
        bird.setJumpForce(bird.getJumpForce() * heightResizeValue);
    }

    public void resizeButtons(Game game) {
        game.getStartButton().setBounds(0, 0, game.getStartButton().getWidth() * widthResizeValue, game.getStartButton().getButtonHeight() * heightResizeValue);
        game.getStartButton().setLocation(0, 0);
        game.getResetButton().setBounds(0, 0, game.getResetButton().getWidth() * widthResizeValue, game.getResetButton().getButtonHeight() * heightResizeValue);
        game.getResetButton().setLocation(0, 0);
        game.getCloseButton().setBounds(game.getCloseButton().getButtonX() * widthResizeValue, game.getCloseButton().getButtonY() * heightResizeValue, game.getCloseButton().getWidth() * widthResizeValue, game.getCloseButton().getButtonHeight() * heightResizeValue);
        game.getCloseButton().setLocation(game.getWidth() - game.getCloseButton().getWidth(), 0);
        game.getFullscreenButton().setBounds(game.getFullscreenButton().getButtonX() * widthResizeValue, game.getFullscreenButton().getButtonY() * heightResizeValue, game.getFullscreenButton().getWidth() * widthResizeValue, game.getFullscreenButton().getButtonHeight() * heightResizeValue);
        game.getFullscreenButton().setLocation(game.getWidth() - game.getCloseButton().getWidth() - game.getFullscreenButton().getWidth(), 0);
    }

    public void resizeButtonsBack(Game game) {
        game.getStartButton().setBounds(0, 0, game.getStartButton().getWidth() / widthResizeValue, game.getStartButton().getButtonHeight() / heightResizeValue);
        game.getStartButton().setLocation(0, 0);
        game.getResetButton().setBounds(0, 0, game.getResetButton().getWidth() / widthResizeValue, game.getResetButton().getButtonHeight() / heightResizeValue);
        game.getResetButton().setLocation(0, 0);
        game.getCloseButton().setBounds(game.getCloseButton().getButtonX() / widthResizeValue, game.getCloseButton().getButtonY() / heightResizeValue, game.getCloseButton().getWidth() / widthResizeValue, game.getCloseButton().getButtonHeight() / heightResizeValue);
        game.getCloseButton().setLocation(game.getWidth() - game.getCloseButton().getWidth(), 0);
        game.getFullscreenButton().setBounds(game.getFullscreenButton().getButtonX() / widthResizeValue, game.getFullscreenButton().getButtonY() / heightResizeValue, game.getFullscreenButton().getWidth() / widthResizeValue, game.getFullscreenButton().getButtonHeight() / heightResizeValue);
        game.getFullscreenButton().setLocation(game.getWidth() - game.getCloseButton().getWidth() - game.getFullscreenButton().getWidth(), 0);
    }

    public void resizeWindow(FlappyBird flappyBird, Game game, Bird bird) {
        /*bird.setNormalBirdImage(new ImageIcon(newNormalBirdImage));
        bird.setBirdFallingImage(new ImageIcon(newBirdFallingImage));
        bird.setBirdSemiFallingImage(new ImageIcon(newBirdSemiFallingImage));
        bird.setBirdJumpImage(new ImageIcon(newBirdJumpImage));
        bird.setBirdImage(new ImageIcon(newNormalBirdImage));*/
        game.setBackgroundImage(new ImageIcon(newBackgroundImage));
        flappyBird.setSize(screenSize);
        /*game.setBottomPipeImage(new ImageIcon(newBottomPipeImage));
        game.setTopPipeImage(new ImageIcon(newTopPipeImage));*/
    }

    public void resizeWindowBack(FlappyBird flappyBird, Game game, Bird bird) {
        /*bird.setNormalBirdImage(new ImageIcon(normalBirdImage));
        bird.setBirdFallingImage(new ImageIcon(birdFallingImage));
        bird.setBirdSemiFallingImage(new ImageIcon(birdSemiFallingImage));
        bird.setBirdJumpImage(new ImageIcon(birdJumpImage));
        bird.setBirdImage(new ImageIcon(normalBirdImage));*/
        game.setBackgroundImage(new ImageIcon(backgroundImage));
        flappyBird.setSize(game.getBackgroundWidth(), game.getBackgroundHeight());
        /*game.setBottomPipeImage(new ImageIcon(bottomPipeImage));
        game.setTopPipeImage(new ImageIcon(topPipeImage));*/
    }

    public void decreaseOtherSize(Game game, Bird bird) {
        game.setBaseGameSpeed(game.getBaseGameSpeed() / widthResizeValue);
        game.setGameSpeedIncreaseSize(game.getGameSpeedIncreaseSize() / widthResizeValue);
        game.setPipeDifficulty(game.getPipeDifficulty() / heightResizeValue);
        game.setPipeGap(game.getPipeGap() / heightResizeValue);
        /*bird.setBirdHeight(bird.getBirdHeight() / heightResizeValue);
        bird.setBirdWidth(bird.getBirdWidth() / widthResizeValue);*/
        bird.setGravity(bird.getGravity() / heightResizeValue);
        bird.setBirdBaseSpeed(bird.getBirdBaseSpeed() / heightResizeValue);
        bird.setJumpForce(bird.getJumpForce() / heightResizeValue);
    }
}
