import javax.swing.*;

public class FlappyBird extends JFrame {
    private Game game;
    private StartButton startButton;

    public FlappyBird(String backgroundImageName, String birdImageName, String bottomPipeImageName, String topPipeImageName) {
        game = new Game(backgroundImageName, birdImageName, bottomPipeImageName, topPipeImageName);
        //this.setResizable(false);
        setSize(game.getBackgroundWidth(), game.getBackgroundHeight());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.add(game);
        this.setComponentZOrder(game, 0);
        this.pack();
        this.setVisible(true);
        this.game.requestFocus();
    }
}
