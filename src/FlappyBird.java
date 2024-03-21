import javax.swing.*;
import java.awt.*;

public class FlappyBird extends JFrame {
    private Background background;
    public FlappyBird(){
        background = new Background();
        setSize(900,504);

        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(background);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
}
