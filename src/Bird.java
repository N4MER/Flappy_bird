import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Bird implements KeyListener {
    private ImageIcon birdImage;
    private int birdHeight;
    private int birdWidth;
    private int birdX;
    private int birdY;
    private int birdSpeed = 0;
    private int gravity = 1;

    public Bird(String birdImageName) {
        this.birdImage = new ImageIcon(birdImageName);
        this.birdHeight = birdImage.getIconHeight();
        this.birdWidth = birdImage.getIconWidth();
    }

    public void birdMovement(ImageIcon background) {
        birdSpeed += gravity;
        if (background.getIconHeight() - birdY - birdHeight < birdSpeed) {
            birdY = background.getIconHeight() - birdHeight;
        } else if (birdY + birdSpeed <= 0) {
            birdY = 0;
            birdSpeed=0;
        } else {
            birdY += birdSpeed;
        }

    }


    public ImageIcon getBirdImage() {
        return birdImage;
    }


    public int getBirdHeight() {
        return birdHeight;
    }

    public int getBirdWidth() {
        return birdWidth;
    }

    public int getBirdX() {
        return birdX;
    }

    public void setBirdX(int birdX) {
        this.birdX = birdX;
    }

    public int getBirdY() {
        return birdY;
    }

    public void setBirdY(int birdY) {
        this.birdY = birdY;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            birdSpeed = -10;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }


    @Override
    public void keyReleased(KeyEvent e) {
    }
}
