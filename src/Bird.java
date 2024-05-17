import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Bird implements KeyListener, MouseListener {
    private ImageIcon birdImage;
    private int birdHeight;
    private int birdWidth;
    private int birdX;
    private int birdY;
    private int birdBaseSpeed;
    private int birdSpeed = birdBaseSpeed;
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
            birdSpeed = 0;
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

    public int getBirdSpeed() {
        return birdSpeed;
    }

    public void setBirdSpeed(int birdSpeed) {
        this.birdSpeed = birdSpeed;
    }

    public int getBirdBaseSpeed() {
        return birdBaseSpeed;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            birdSpeed = -12;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            birdSpeed = -12;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
