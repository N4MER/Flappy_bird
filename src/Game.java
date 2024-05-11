import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Game extends JPanel implements ActionListener {
    private ImageIcon backgroundImage;
    private Bird bird;
    private ImageIcon bottomPipeImage;
    private ImageIcon topPipeImage;
    private Timer gameLoop;
    private Timer pipeSpawnRate;
    private ArrayList<Pipe> pipes = new ArrayList<>();
    private Random random;

    public Game(String backGroundImageName, String birdImageName, String bottomPipeImageName,String topPipeImageName) {
        this.backgroundImage = new ImageIcon(backGroundImageName);
        this.bird = new Bird(birdImageName);
        this.bottomPipeImage = new ImageIcon(bottomPipeImageName);
        this.topPipeImage = new ImageIcon(topPipeImageName);
        this.setFocusable(true);
        this.addKeyListener(bird);
        this.addMouseListener(bird);
        this.random = new Random();
        this.gameLoop = new Timer(1000 / 60, this);
        this.pipeSpawnRate = new Timer(2000, e -> addPipes());
        this.bird.setBirdX(backgroundImage.getIconWidth() / 8);
        this.bird.setBirdY(backgroundImage.getIconHeight() / 2 + bird.getBirdHeight());
        //this.setLayout(new BorderLayout());
        pipeSpawnRate.start();
        gameLoop.start();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.drawImage(backgroundImage.getImage(), 0, 0, null);
        g.drawImage(bird.getBirdImage().getImage(), bird.getBirdX(), bird.getBirdY(), null);
        drawPipes(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(getBackgroundWidth(), getBackgroundHeight());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bird.birdMovement(backgroundImage);
        repaint();
        moveAllPipes();
        repaint();
    }

    public void drawPipes(Graphics g) {
        for (Pipe pipe : pipes) {
            g.drawImage(bottomPipeImage.getImage(), pipe.getPipeX(), pipe.getPipeY(), null);
            g.drawImage(topPipeImage.getImage(),pipe.getPipeX(),pipe.getPipeY()-120-topPipeImage.getIconHeight(),null);
        }
    }

    public void addPipes() {
        int randomY = random.nextInt(backgroundImage.getIconHeight());
        Pipe pipe = new Pipe(randomY, bottomPipeImage, backgroundImage);
        this.pipes.add(pipe);
    }

    public void moveAllPipes() {
        for (Pipe pipe : pipes) {
            pipe.setPipeX(pipe.getPipeX()-pipe.getMoveSpeed());
        }
    }


    public int getBackgroundWidth() {
        return backgroundImage.getIconWidth();
    }

    public int getBackgroundHeight() {
        return backgroundImage.getIconHeight();
    }
}
