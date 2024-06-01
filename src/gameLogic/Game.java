package gameLogic;

import UI.*;
import entities.Bird;
import entities.Pipe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/**
 * The type Game.
 */
public class Game extends JPanel implements ActionListener {
    private ImageIcon backgroundImage;
    private Bird bird;
    private ImageIcon bottomPipeImage;
    private ImageIcon topPipeImage;
    private Timer gameLoop;
    private Timer pipeSpawner;
    private ArrayList<Pipe> pipes;
    private Random random;
    private int randomY;
    private int randomPipe;
    private int pipeMaxY;
    private int pipeMinY;
    private boolean gameOver;
    private int baseGameSpeed;
    private int gameSpeed;
    private int gameSpeedIncreaseSize;
    private int scoreCountForGameSpeedIncrease;
    private int pipeGap;
    private int pipeDifficulty;
    private int score;
    private double basePipeSpawnRate;
    private double pipeSpawnRate;
    private StartButton startButton;
    private ResetButton resetButton;
    private CloseButton closeButton;
    private FullscreenButton fullscreenButton;
    private int randomDirection;
    private boolean isAtStartScreen = true;

    /**
     * Instantiates a new Game.
     * Sets needed parameters.
     * Instantiates needed objects.
     * Adds buttons.
     * @param flappyBird               the flappy bird
     * @param backgroundImageName      the background image name
     * @param birdImageName            the bird image name
     * @param birdFallingImageName     the bird falling image name
     * @param birdSemiFallingImageName the bird semi falling image name
     * @param birdJumpImageName        the bird jump image name
     * @param bottomPipeImageName      the bottom pipe image name
     * @param topPipeImageName         the top pipe image name
     */
    public Game(FlappyBird flappyBird, String backgroundImageName, String birdImageName, String birdFallingImageName, String birdSemiFallingImageName, String birdJumpImageName, String bottomPipeImageName, String topPipeImageName) {
        pipes = new ArrayList<>();
        random = new Random();
        backgroundImage = new ImageIcon(backgroundImageName);
        bird = new Bird(birdImageName, birdFallingImageName, birdSemiFallingImageName, birdJumpImageName);
        bottomPipeImage = new ImageIcon(bottomPipeImageName);
        topPipeImage = new ImageIcon(topPipeImageName);
        basePipeSpawnRate = 1500;
        pipeSpawnRate = basePipeSpawnRate;
        gameLoop = new Timer(1000 / 60, this);
        pipeSpawner = new Timer((int) pipeSpawnRate, e -> addPipes());
        pipeDifficulty = 80;
        pipeGap = 150;
        pipeMaxY = backgroundImage.getIconHeight() - pipeDifficulty;
        pipeMinY = pipeDifficulty;
        randomY = backgroundImage.getIconHeight() / 2 + pipeGap / 2;
        bird.setBirdX(backgroundImage.getIconWidth() / 8);
        bird.setBirdY(backgroundImage.getIconHeight() / 2 + bird.getBirdHeight());
        gameOver = false;
        baseGameSpeed = 8;
        gameSpeed = baseGameSpeed;
        gameSpeedIncreaseSize = 1;
        scoreCountForGameSpeedIncrease = 5;
        score = 0;
        startButton = new StartButton(this);
        resetButton = new ResetButton(this);
        closeButton = new CloseButton(this);
        fullscreenButton = new FullscreenButton(flappyBird, this);
        setLayout(null);
        setFocusable(true);
        add(startButton);
        add(closeButton);
        add(fullscreenButton);
        addKeyListener(bird);
        addMouseListener(bird);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage.getImage(), 0, 0, null);
        g.drawImage(bird.getBirdImage().getImage(), bird.getBirdX(), bird.getBirdY(), null);
        drawPipes(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 32));
        g.drawString("Score: " + score, 0, 35);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bird.birdMovement(backgroundImage);
        moveAllPipes();
        repaint();
        checkIfPassed();
        calculateScore();
        calculateGameSpeed();
        calculatePipeSpawnRate();
    }

    /**
     * Check if passed.
     * Checks if any game over conditions are met.
     * If yes -> stops the game and adds reset button.
     * Sets passed pipes passed boolean to true.
     */
    public void checkIfPassed() {
        if (isGameOver()) {
            pipeSpawner.stop();
            gameLoop.stop();
            this.add(resetButton);
        }
        for (Pipe pipe : pipes) {
            if (collidedWithPipe(bird, pipe)) {
                gameOver = true;
            }
            if (!pipe.isPassed()) {
                if (passedPipe(bird, pipe)) {
                    pipe.setPassed(true);
                }
            }
        }
    }

    /**
     * Calculate score.
     */
    public void calculateScore() {
        score = 0;
        for (Pipe pipe : pipes) {
            if (pipe.isPassed()) {
                score++;
            }
        }
        score = score / 2;
    }

    /**
     * Calculate game speed.
     */
    public void calculateGameSpeed() {
        double speedIncreaseCount = Math.floor((double) score / (double) scoreCountForGameSpeedIncrease);
        gameSpeed = baseGameSpeed + ((int) speedIncreaseCount * gameSpeedIncreaseSize);
    }

    /**
     * Calculate pipe spawn rate.
     */
    public void calculatePipeSpawnRate() {
        pipeSpawnRate = basePipeSpawnRate / ((double) gameSpeed / (double) baseGameSpeed);
        pipeSpawner.setDelay((int) pipeSpawnRate);
    }

    /**
     * Draw pipes.
     *
     * @param g the g
     */
    public void drawPipes(Graphics g) {
        for (Pipe pipe : pipes) {
            g.drawImage(pipe.getPipeImage().getImage(), pipe.getPipeX(), pipe.getPipeY(), null);
        }
    }

    /**
     * Add pipes.
     * Generates random Y, random direction, random pipe (if the condition is met).
     * Creates pipes with random parameters and adds them to pipes arrayList.
     */
    public void addPipes() {
        randomY = random.nextInt(pipeMaxY - pipeGap - pipeMinY) + pipeMinY + pipeGap;
        randomDirection = random.nextInt(2) + 1;
        if (score <= 5) {
            randomPipe = 2;
        } else {
            randomPipe = random.nextInt(5) + 1;
        }
        Pipe bottomPipe = CreatePipes.createPipes(randomPipe, randomY, topPipeImage, bottomPipeImage, backgroundImage, this, false, randomDirection).getBottomPipe();
        Pipe topPipe = CreatePipes.createPipes(randomPipe, bottomPipe.getPipeY() - pipeGap - topPipeImage.getIconHeight(), topPipeImage, bottomPipeImage, backgroundImage, this, true, randomDirection).getTopPipe();
        pipes.add(bottomPipe);
        pipes.add(topPipe);
    }

    /**
     * Move all pipes.
     */
    public void moveAllPipes() {
        for (Pipe pipe : pipes) {
            pipe.move(this);
        }
    }

    /**
     * Collided with pipe boolean.
     * Checks if bird collided with a pipe.
     * @param bird the bird
     * @param pipe the pipe
     * @return the boolean
     */
// copied from internet
    public boolean collidedWithPipe(Bird bird, Pipe pipe) {
        return bird.getBirdX() <= pipe.getPipeX() + pipe.getPipeWidth() &&
                bird.getBirdX() + bird.getBirdWidth() >= pipe.getPipeX() &&
                bird.getBirdY() <= pipe.getPipeY() + pipe.getPipeHeight() &&
                bird.getBirdY() + bird.getBirdHeight() >= pipe.getPipeY();
    }

    /**
     * Passed pipe boolean.
     * Checks if bird passed the pipe.
     * @param bird the bird
     * @param pipe the pipe
     * @return the boolean
     */
    public boolean passedPipe(Bird bird, Pipe pipe) {
        return bird.getBirdX() > pipe.getPipeX() + pipe.getPipeWidth();
    }

    /**
     * Start game.
     * Starts the game.
     * Removes the start button.
     */
    public void startGame() {
        remove(startButton);
        isAtStartScreen = false;
        pipeSpawner.start();
        gameLoop.start();
        bird.jump();
    }

    /**
     * Reset game.
     * Resets the game.
     * Adds start button and removes reset button.
     * Sets all necessary parameters to base.
     */
    public void resetGame() {
        repaint();
        bird.setBirdSpeed(bird.getBirdBaseSpeed());
        bird.setBirdImage(bird.getNormalBirdImage());
        gameSpeed = baseGameSpeed;
        pipeSpawnRate = basePipeSpawnRate;
        bird.setBirdY(backgroundImage.getIconHeight() / 2 + bird.getBirdHeight());
        gameOver = false;
        pipes.clear();
        pipeSpawner.stop();
        gameLoop.stop();
        add(startButton);
        isAtStartScreen = true;
        remove(resetButton);
    }

    /**
     * Is game over boolean.
     * Checks if bird hit the bottom.
     * @return the boolean
     */
    public boolean isGameOver() {
        if (bird.getBirdY() + bird.getBirdHeight() >= backgroundImage.getIconHeight()) {
            gameOver = true;
        }
        return gameOver;
    }

    /**
     * Gets background width.
     *
     * @return the background width
     */
    public int getBackgroundWidth() {
        return backgroundImage.getIconWidth();
    }

    /**
     * Gets background height.
     *
     * @return the background height
     */
    public int getBackgroundHeight() {
        return backgroundImage.getIconHeight();
    }

    /**
     * Gets pipe min y.
     *
     * @return the pipe min y
     */
    public int getPipeMinY() {
        return pipeMinY;
    }

    /**
     * Gets pipe max y.
     *
     * @return the pipe max y
     */
    public int getPipeMaxY() {
        return pipeMaxY;
    }

    /**
     * Gets game speed.
     *
     * @return the game speed
     */
    public int getGameSpeed() {
        return gameSpeed;
    }

    /**
     * Gets pipe gap.
     *
     * @return the pipe gap
     */
    public int getPipeGap() {
        return pipeGap;
    }

    /**
     * Gets background image.
     *
     * @return the background image
     */
    public ImageIcon getBackgroundImage() {
        return backgroundImage;
    }

    /**
     * Sets background image.
     *
     * @param backgroundImage the background image
     */
    public void setBackgroundImage(ImageIcon backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    /**
     * Gets bird.
     *
     * @return the bird
     */
    public Bird getBird() {
        return bird;
    }

    /**
     * Sets pipe gap.
     *
     * @param pipeGap the pipe gap
     */
    public void setPipeGap(int pipeGap) {
        this.pipeGap = pipeGap;
    }

    /**
     * Gets base game speed.
     *
     * @return the base game speed
     */
    public int getBaseGameSpeed() {
        return baseGameSpeed;
    }

    /**
     * Sets base game speed.
     *
     * @param baseGameSpeed the base game speed
     */
    public void setBaseGameSpeed(int baseGameSpeed) {
        this.baseGameSpeed = baseGameSpeed;
    }


    /**
     * Gets game speed increase size.
     *
     * @return the game speed increase size
     */
    public int getGameSpeedIncreaseSize() {
        return gameSpeedIncreaseSize;
    }

    /**
     * Sets game speed increase size.
     *
     * @param gameSpeedIncreaseSize the game speed increase size
     */
    public void setGameSpeedIncreaseSize(int gameSpeedIncreaseSize) {
        this.gameSpeedIncreaseSize = gameSpeedIncreaseSize;
    }

    /**
     * Gets pipe difficulty.
     *
     * @return the pipe difficulty
     */
    public int getPipeDifficulty() {
        return pipeDifficulty;
    }

    /**
     * Sets pipe difficulty.
     *
     * @param pipeDifficulty the pipe difficulty
     */
    public void setPipeDifficulty(int pipeDifficulty) {
        this.pipeDifficulty = pipeDifficulty;
    }

    /**
     * Gets reset button.
     *
     * @return the reset button
     */
    public ResetButton getResetButton() {
        return resetButton;
    }

    /**
     * Gets start button.
     *
     * @return the start button
     */
    public StartButton getStartButton() {
        return startButton;
    }

    /**
     * Gets close button.
     *
     * @return the close button
     */
    public CloseButton getCloseButton() {
        return closeButton;
    }

    /**
     * Gets fullscreen button.
     *
     * @return the fullscreen button
     */
    public FullscreenButton getFullscreenButton() {
        return fullscreenButton;
    }

    /**
     * Sets pipe max y.
     *
     * @param pipeMaxY the pipe max y
     */
    public void setPipeMaxY(int pipeMaxY) {
        this.pipeMaxY = pipeMaxY;
    }

    /**
     * Is at start screen boolean.
     *
     * @return the boolean
     */
    public boolean isAtStartScreen() {
        return isAtStartScreen;
    }

    /**
     * Gets pipes.
     *
     * @return the pipes
     */
    public ArrayList<Pipe> getPipes() {
        return pipes;
    }

    /**
     * Gets game loop.
     *
     * @return the game loop
     */
    public Timer getGameLoop() {
        return gameLoop;
    }

    /**
     * Gets pipe spawner.
     *
     * @return the pipe spawner
     */
    public Timer getPipeSpawner() {
        return pipeSpawner;
    }

    /**
     * Sets game over.
     *
     * @param gameOver the game over
     */
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public int getScore() {
        return score;
    }
}

