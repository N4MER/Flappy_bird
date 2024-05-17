import javax.swing.*;

public class FlappyBird extends JFrame {
    private Game game;
    private StartButton startButton;

    public FlappyBird(String backgroundImageName, String birdImageName, String bottomPipeImageName, String topPipeImageName) {
        game = new Game(backgroundImageName, birdImageName, bottomPipeImageName, topPipeImageName);
        //this.setResizable(false);
        setSize(game.getBackgroundWidth(), game.getBackgroundHeight());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        add(game);
        setComponentZOrder(game, 0);
        pack();
        setVisible(true);
        game.requestFocus();
    }
}
