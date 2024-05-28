import javax.swing.*;

public class FlappyBird extends JFrame {
    private Game game;
    private GameScaler gameScaler;

    public FlappyBird(String backgroundImageName, String birdImageName, String birdFallingImageName, String birdSemiFallingImageName, String birdJumpImageName, String bottomPipeImageName, String topPipeImageName) {
        game = new Game(this, backgroundImageName, birdImageName, birdFallingImageName, birdSemiFallingImageName, birdJumpImageName, bottomPipeImageName, topPipeImageName);
        add(game);
        setSize(game.getBackgroundWidth(), game.getBackgroundHeight());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);
        setResizable(false);
        gameScaler = new GameScaler(game);
        setComponentZOrder(game, 0);
        pack();
        game.initializeGame();
        getGameScaler().resize(this,game,game.getBird());
        getGameScaler().resizeBack(this,game,game.getBird());
        setSize(game.getWidth(),game.getBackgroundHeight());
        setLocationRelativeTo(null);
        setVisible(true);
        game.requestFocus();
    }

    public GameScaler getGameScaler() {
        return gameScaler;
    }
}
