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
    private ArrayList<Pipe> pipes;
    private Random random;
    private int randomY;
    private int pipeMaxY;
    private int pipeMinY;
    private boolean gameOver;
    private int baseGameSpeed = 8;
    private int gameSpeed = baseGameSpeed;
    private int gameIncreaseSize = 5;
    private int scoreCountForGameSpeedIncrease = 1;
    private int pipeGap = 140;
    private int pipeDifficulty = 50;
    private int score = 0;
    private double pipeSpawnDelay = 2000;

    public Game(String backGroundImageName, String birdImageName, String bottomPipeImageName, String topPipeImageName) {
        this.backgroundImage = new ImageIcon(backGroundImageName);
        this.bird = new Bird(birdImageName);
        this.bottomPipeImage = new ImageIcon(bottomPipeImageName);
        this.topPipeImage = new ImageIcon(topPipeImageName);
        this.pipes = new ArrayList<>();
        this.setFocusable(true);
        this.addKeyListener(bird);
        this.addMouseListener(bird);
        this.pipeMaxY = backgroundImage.getIconHeight() - pipeDifficulty;
        this.pipeMinY = pipeDifficulty + pipeGap;
        this.random = new Random();
        this.randomY = random.nextInt(pipeMaxY - pipeMinY) + pipeMinY;
        this.gameOver = false;
        this.gameLoop = new Timer(1000 / 60, this);
        this.pipeSpawnRate = new Timer((int) pipeSpawnDelay, e -> addPipes());
        this.bird.setBirdX(backgroundImage.getIconWidth() / 8);
        this.bird.setBirdY(backgroundImage.getIconHeight() / 2 + bird.getBirdHeight());
        pipeSpawnRate.start();
        gameLoop.start();

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
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(getBackgroundWidth(), getBackgroundHeight());
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
    public void checkIfPassed(){
        for (Pipe pipe : pipes) {
            if (collidedWithPipe(bird, pipe)) {
                gameOver = true;
            }
        }
        if (isGameOver()) {
            pipeSpawnRate.stop();
            gameLoop.stop();
        }
        for (Pipe pipe : pipes) {
            pipe.setPassed(true);
        }
    }

    public void calculateScore() {
        score = 0;
        for (Pipe pipe : pipes) {
            if (pipe.isPassed()) {
                score++;
            }
        }
    }

    public void calculateGameSpeed() {
        double dividedScore = score / scoreCountForGameSpeedIncrease;
        gameSpeed = baseGameSpeed + (int) Math.floor(dividedScore) * gameIncreaseSize;

    }

    public void calculatePipeSpawnRate() {
        double spawnDelayReduceVolume = gameIncreaseSize/baseGameSpeed;
        pipeSpawnDelay = 2000 / spawnDelayReduceVolume;
    }

    public void drawPipes(Graphics g) {
        for (Pipe pipe : pipes) {
            g.drawImage(pipe.getPipeImage().getImage(), pipe.getPipeX(), pipe.getPipeY(), null);
        }
    }

    public void addPipes() {
        Pipe bottomPipe = new Pipe(randomY, bottomPipeImage, backgroundImage);
        Pipe topPipe = new Pipe(bottomPipe.getPipeY() - pipeGap - topPipeImage.getIconHeight(), topPipeImage, backgroundImage);
        this.pipes.add(bottomPipe);
        this.pipes.add(topPipe);
        if (bottomPipe.getPipeY() - pipeDifficulty - 140 < pipeMinY) {
            randomY = random.nextInt(2 * pipeDifficulty + pipeGap) + pipeMinY;
        } else {
            randomY = random.nextInt(2 * pipeDifficulty + pipeGap) + bottomPipe.getPipeY() - pipeGap - pipeDifficulty;
        }
    }

    public void moveAllPipes() {
        for (Pipe pipe : pipes) {
            pipe.setPipeX(pipe.getPipeX() - gameSpeed);
        }
    }

    public boolean isGameOver() {
        if (bird.getBirdY() + bird.getBirdHeight() >= backgroundImage.getIconHeight()) {
            gameOver = true;
        }
        return gameOver;
    }

    //copied from internet
    public boolean collidedWithPipe(Bird bird, Pipe pipe) {
        return bird.getBirdX() <= pipe.getPipeX() + pipe.getPipeWidth() &&
                bird.getBirdX() + bird.getBirdWidth() >= pipe.getPipeX() &&
                bird.getBirdY() <= pipe.getPipeY() + pipe.getPipeHeight() &&
                bird.getBirdY() + bird.getBirdHeight() >= pipe.getPipeY();

    }


    public int getBackgroundWidth() {
        return backgroundImage.getIconWidth();
    }

    public int getBackgroundHeight() {
        return backgroundImage.getIconHeight();
    }
}
