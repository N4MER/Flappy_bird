import javax.swing.*;

public class FlappyBird extends JFrame {
    private Game game;
    public FlappyBird(String backgroundImageName,String birdImageName,String pipeImageName){
        game = new Game(backgroundImageName,birdImageName,pipeImageName);
        //this.setResizable(false);
        setSize(game.getBackgroundWidth(), game.getBackgroundHeight());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(game);
        this.pack();
        this.game.requestFocus();
        this.setVisible(true);
    }


}
