import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Game extends JPanel implements ActionListener {
    private ImageIcon backgroundImage;
    private Bird bird;
    private ImageIcon bottomPipeImage;
    private ImageIcon topPipeImage;
    private Timer gameLoop;
    private Timer pipeSpawnRate;
    private ArrayList<Pipe> pipes = new ArrayList<>();
    private Random random = new Random();
    private int randomY;
    private int randomPipe;
    private int pipeMaxY;
    private int pipeMinY;
    private boolean gameOver = false;
    private int baseGameSpeed = 8;
    private int gameSpeed = baseGameSpeed;
    private int gameSpeedIncreaseSize = 1;
    private int scoreCountForGameSpeedIncrease = 5;
    private int pipeGap = 150;
    private int pipeDifficulty = 80;
    private int score = 0;
    private double basePipeSpawnDelay = 1500;
    private double pipeSpawnDelay = basePipeSpawnDelay;
    private StartButton startButton;
    private ResetButton resetButton;

    public Game(String backGroundImageName, String birdImageName, String birdFallingImageName, String birdSemiFallingImageName, String birdJumpImageName, String bottomPipeImageName, String topPipeImageName) {
        backgroundImage = new ImageIcon(backGroundImageName);
        bird = new Bird(birdImageName, birdFallingImageName, birdSemiFallingImageName, birdJumpImageName);
        bottomPipeImage = new ImageIcon(bottomPipeImageName);
        topPipeImage = new ImageIcon(topPipeImageName);
        gameLoop = new Timer(1000 / 60, this);
        pipeSpawnRate = new Timer((int) pipeSpawnDelay, e -> addPipes());
        startButton = new StartButton(this);
        resetButton = new ResetButton(this);
        setLayout(null);
        setFocusable(true);
        addKeyListener(bird);
        addMouseListener(bird);
        pipeMaxY = backgroundImage.getIconHeight() - pipeDifficulty;
        pipeMinY = pipeDifficulty;
        randomY = random.nextInt(pipeMaxY - pipeGap - pipeMinY) + pipeMinY + pipeGap;
        bird.setBirdX(backgroundImage.getIconWidth() / 8);
        bird.setBirdY(backgroundImage.getIconHeight() / 2 + bird.getBirdHeight());
        add(startButton);
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
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

    public void checkIfPassed() {
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
        if (isGameOver()) {
            pipeSpawnRate.stop();
            gameLoop.stop();
            this.add(resetButton);
        }
    }

    public void calculateScore() {
        score = 0;
        for (Pipe pipe : pipes) {
            if (pipe.isPassed()) {
                score++;
            }
        }
        score = score / 2;
    }

    public void calculateGameSpeed() {
        double speedIncreaseCount = Math.floor((double) score / (double) scoreCountForGameSpeedIncrease);
        gameSpeed = baseGameSpeed + ((int) speedIncreaseCount * gameSpeedIncreaseSize);
    }

    public void calculatePipeSpawnRate() {
        pipeSpawnDelay = basePipeSpawnDelay / ((double) gameSpeed / (double) baseGameSpeed);
        pipeSpawnRate.setDelay((int) pipeSpawnDelay);
    }

    public void drawPipes(Graphics g) {
        for (Pipe pipe : pipes) {
            g.drawImage(pipe.getPipeImage().getImage(), pipe.getPipeX(), pipe.getPipeY(), null);
        }
    }

    public void addPipes() {
        randomY = random.nextInt(pipeMaxY - pipeGap - pipeMinY) + pipeMinY + pipeGap;
        if (score <= 5) {
            randomPipe = 1;
        } else {
            randomPipe = random.nextInt(3) + 1;
        }
        Pipe bottomPipe = CreatePipes.createPipes(randomPipe, randomY, topPipeImage, bottomPipeImage, backgroundImage, this).getBottomPipe();
        Pipe topPipe = CreatePipes.createPipes(randomPipe, bottomPipe.getPipeY() - pipeGap - topPipeImage.getIconHeight(), topPipeImage, bottomPipeImage, backgroundImage, this).getTopPipe();
        pipes.add(bottomPipe);
        pipes.add(topPipe);
    }

    public void moveAllPipes() {
        for (Pipe pipe : pipes) {
            pipe.move(gameSpeed);
            pipe.moveUp();
        }
    }

    // copied from internet
    public boolean collidedWithPipe(Bird bird, Pipe pipe) {
        return bird.getBirdX() <= pipe.getPipeX() + pipe.getPipeWidth() &&
                bird.getBirdX() + bird.getBirdWidth() >= pipe.getPipeX() &&
                bird.getBirdY() <= pipe.getPipeY() + pipe.getPipeHeight() &&
                bird.getBirdY() + bird.getBirdHeight() >= pipe.getPipeY();
    }

    public boolean passedPipe(Bird bird, Pipe pipe) {
        return bird.getBirdX() > pipe.getPipeX() + pipe.getPipeWidth();
    }

    public void startGame() {
        remove(startButton);
        Pipe bottomPipe = new Pipe(randomY, bottomPipeImage, backgroundImage);
        Pipe topPipe = new Pipe(bottomPipe.getPipeY() - pipeGap - topPipeImage.getIconHeight(), topPipeImage, backgroundImage);
        pipes.add(bottomPipe);
        pipes.add(topPipe);
        pipeSpawnRate.start();
        gameLoop.start();
        bird.jump();
    }

    public void resetGame() {
        repaint();
        bird.setBirdSpeed(bird.getBirdBaseSpeed());
        bird.setBirdImage(bird.getNormalBirdImage());
        gameSpeed = baseGameSpeed;
        pipeSpawnDelay = basePipeSpawnDelay;
        bird.setBirdY(backgroundImage.getIconHeight() / 2 + bird.getBirdHeight());
        gameOver = false;
        pipes.clear();
        pipeSpawnRate.stop();
        gameLoop.stop();
        add(startButton);
        remove(resetButton);
    }

    public int getBackgroundWidth() {
        return backgroundImage.getIconWidth();
    }

    public int getBackgroundHeight() {
        return backgroundImage.getIconHeight();
    }

    public boolean isGameOver() {
        if (bird.getBirdY() + bird.getBirdHeight() >= backgroundImage.getIconHeight()) {
            gameOver = true;
        }
        return gameOver;
    }

    public int getPipeMinY() {
        return pipeMinY;
    }

    public int getPipeMaxY() {
        return pipeMaxY;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(getBackgroundWidth(), getBackgroundHeight());
    }
}

