package unitTests;

import UI.FlappyBird;
import entities.Bird;
import entities.Pipe;
import gameLogic.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import javax.swing.ImageIcon;

class GameTest {
    private Game game;
    private Bird bird;
    private Pipe pipe;
    private FlappyBird flappyBird;

    @BeforeEach
    void setUp() {
        flappyBird = new FlappyBird(
                "src/flappyBirdImages/background.png",
                "src/flappyBirdImages/flappyBird.png",
                "src/flappyBirdImages/flappyBirdFalling.png",
                "src/flappyBirdImages/flappyBirdSemiFalling.png",
                "src/flappyBirdImages/flappyBirdGoingUp.png",
                "src/flappyBirdImages/bottomPipe.png",
                "src/flappyBirdImages/topPipe.png"
        );

        game = flappyBird.getGame();
        bird = game.getBird();
        ImageIcon pipeImage = new ImageIcon("src/flappyBirdImages/bottomPipe.png");
        ImageIcon backgroundImage = new ImageIcon("src/flappyBirdImages/background.png");
        pipe = new Pipe(100, pipeImage, backgroundImage, game, false, 1);
    }

    @Test
    void testNoCollision() {
        bird.setBirdX(10);
        bird.setBirdY(10);
        bird.setBirdWidth(10);
        bird.setBirdHeight(10);

        pipe.setPipeX(100);
        pipe.setPipeY(100);
        pipe.setPipeWidth(20);
        pipe.setPipeHeight(20);

        assertFalse(game.collidedWithPipe(bird, pipe));
    }

    @Test
    void testCollisionFromLeft() {
        bird.setBirdX(30);
        bird.setBirdY(15);
        bird.setBirdWidth(10);
        bird.setBirdHeight(10);

        pipe.setPipeX(35);
        pipe.setPipeY(10);
        pipe.setPipeWidth(20);
        pipe.setPipeHeight(20);

        assertTrue(game.collidedWithPipe(bird, pipe));
    }

    @Test
    void testCollisionFromRight() {
        bird.setBirdX(40);
        bird.setBirdY(15);
        bird.setBirdWidth(10);
        bird.setBirdHeight(10);

        pipe.setPipeX(30);
        pipe.setPipeY(10);
        pipe.setPipeWidth(20);
        pipe.setPipeHeight(20);

        assertTrue(game.collidedWithPipe(bird, pipe));
    }

    @Test
    void testCollisionFromTop() {
        bird.setBirdX(35);
        bird.setBirdY(5);
        bird.setBirdWidth(10);
        bird.setBirdHeight(10);

        pipe.setPipeX(30);
        pipe.setPipeY(10);
        pipe.setPipeWidth(20);
        pipe.setPipeHeight(20);

        assertTrue(game.collidedWithPipe(bird, pipe));
    }

    @Test
    void testCollisionFromBottom() {
        bird.setBirdX(35);
        bird.setBirdY(25);
        bird.setBirdWidth(10);
        bird.setBirdHeight(10);

        pipe.setPipeX(30);
        pipe.setPipeY(10);
        pipe.setPipeWidth(20);
        pipe.setPipeHeight(20);

        assertTrue(game.collidedWithPipe(bird, pipe));
    }

    @Test
    void testNotPassed() {
        bird.setBirdX(50);
        bird.setBirdY(15);
        bird.setBirdWidth(10);
        bird.setBirdHeight(10);

        pipe.setPipeX(70);
        pipe.setPipeY(10);
        pipe.setPipeWidth(20);
        pipe.setPipeHeight(20);

        assertFalse(game.passedPipe(bird, pipe));
    }

    @Test
    void testPassed() {
        bird.setBirdX(100);
        bird.setBirdY(15);
        bird.setBirdWidth(10);
        bird.setBirdHeight(10);

        pipe.setPipeX(70);
        pipe.setPipeY(10);
        pipe.setPipeWidth(20);
        pipe.setPipeHeight(20);

        assertTrue(game.passedPipe(bird, pipe));
    }

    @Test
    public void testGameStopsWhenGameOver() {
        game.getGameLoop().start();
        game.getPipeSpawner().start();

        game.setGameOver(true);
        game.checkIfPassed();

        assertFalse(game.getGameLoop().isRunning(), "Game loop should be stopped when gameOver is true");
        assertFalse(game.getPipeSpawner().isRunning(), "Pipe spawner should be stopped when gameOver is true");
    }

    @Test
    public void testGameReset() {
        game.getBird().setBirdY(100);
        game.getBird().setBirdSpeed(-10);
        game.getPipes().add(new Pipe(200, new ImageIcon("src/flappyBirdImages/bottomPipe.png"), new ImageIcon("src/flappyBirdImages/background.png"), game, false, 1));
        game.getPipes().add(new Pipe(100, new ImageIcon("src/flappyBirdImages/topPipe.png"), new ImageIcon("src/flappyBirdImages/background.png"), game, true, 1));
        game.checkIfPassed();
        game.setGameOver(true);

        game.resetGame();

        assertFalse(game.isGameOver(), "Game should not be over after reset");
        assertEquals(game.getBackgroundHeight() / 2 + game.getBird().getBirdHeight(), game.getBird().getBirdY(), "Bird Y position should be reset");
        assertEquals(game.getBird().getBirdBaseSpeed(), game.getBird().getBirdSpeed(), "Bird speed should be reset to base speed");
        assertTrue(game.getPipes().isEmpty(), "Pipes list should be empty after reset");
        assertEquals(0, game.getScore(), "Score should be reset to 0");
        assertFalse(game.getGameLoop().isRunning(), "Game loop timer should not be running after reset");
        assertFalse(game.getPipeSpawner().isRunning(), "Pipe spawner timer should not be running after reset");
    }
}

