import javax.swing.*;

public class FlappyBird extends JFrame {
    private Game game;

    public FlappyBird(String backgroundImageName, String birdImageName, String birdFallingImageName, String birdSemiFallingImageName, String birdJumpImageName, String bottomPipeImageName, String topPipeImageName) {
        game = new Game(backgroundImageName, birdImageName, birdFallingImageName, birdSemiFallingImageName, birdJumpImageName, bottomPipeImageName, topPipeImageName);
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
