import javax.swing.*;

public class FlappyBird extends JFrame {
    private Game background;
    public FlappyBird(String backgroundImageName,String birdImageName){
        background = new Game(backgroundImageName,birdImageName);
        setSize(900,504);

        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(background);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
}
