import javax.swing.*;
import java.awt.*;

public class Background extends JPanel {
    private Image background;
    private Image flappyBird;

    public Background() {
        flappyBird = new ImageIcon("bird.png").getImage();
        background = new ImageIcon("background.png").getImage();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        g.drawImage(flappyBird, 100,243, null);
    }

}
