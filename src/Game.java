import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JPanel implements ActionListener {
    private ImageIcon background;
    private Bird bird;
    private Timer gameLoop;

    public Game(String backGroundImageName, String birdImageName) {
        this.background = new ImageIcon(backGroundImageName);
        this.bird = new Bird(birdImageName);
        this.setFocusable(true);
        this.addKeyListener(bird);
        this.addMouseListener(bird);
        this.gameLoop = new Timer(1000/30,this);
        this.bird.setBirdX(background.getIconWidth()/8);
        this.bird.setBirdY(background.getIconHeight()/2+ bird.getBirdHeight());
        this.setLayout(new BorderLayout());

        gameLoop.start();


    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        g.drawImage(background.getImage(), 0, 0, null);
        g.drawImage(bird.getBirdImage().getImage(), bird.getBirdX(), bird.getBirdY(), null);
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(getBackgroundWidth(), getBackgroundHeight());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bird.birdMovement(background);
        repaint();
    }
    public int getBackgroundWidth(){
        return background.getIconWidth();
    }
    public int getBackgroundHeight(){
        return background.getIconHeight();
    }
}
