import javax.swing.*;
import java.awt.*;

public class GameGraphics extends JPanel {
    private ImageIcon background;
    private Bird bird;

    public GameGraphics(String backGroundImageName, String birdImageName) {
        background = new ImageIcon(backGroundImageName);
        this.bird = new Bird(birdImageName);
        this.bird.setBirdX(background.getIconWidth()/8);
        this.bird.setBirdY(background.getIconHeight()/2);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background.getImage(), 0, 0, null);
        g.drawImage(bird.getBirdImage().getImage(), bird.getBirdX(), bird.getBirdY(), null);
    }

}
