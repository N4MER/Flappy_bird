import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Bird implements KeyListener, MouseListener {
    private ImageIcon birdImage;
    private ImageIcon normalBirdImage;
    private ImageIcon birdFallingImage;
    private ImageIcon birdSemiFallingImage;
    private ImageIcon birdJumpImage;
    private int birdHeight;
    private int birdWidth;
    private int birdX;
    private int birdY;
    private int birdBaseSpeed = 8;
    private int birdSpeed = birdBaseSpeed;
    private int gravity = 1;

    public Bird(String birdImageName, String birdFallingImageName, String birdSemiFallingImageName, String birdJumpImageName) {
        birdImage = new ImageIcon(birdImageName);
        normalBirdImage = birdImage;
        birdFallingImage = new ImageIcon(birdFallingImageName);
        birdSemiFallingImage = new ImageIcon(birdSemiFallingImageName);
        birdJumpImage = new ImageIcon(birdJumpImageName);
        birdHeight = birdImage.getIconHeight();
        birdWidth = birdImage.getIconWidth();
    }

    public void birdMovement(ImageIcon background) {
        birdSpeed += gravity;
        changeBirdImage();
        if (background.getIconHeight() - birdY - birdHeight < birdSpeed) {
            birdY = background.getIconHeight() - birdHeight;
        } else if (birdY + birdSpeed <= 0) {
            birdY = 0;
            birdSpeed = 0;
        } else {
            birdY += birdSpeed;
        }

    }

    public void jump() {
        birdSpeed = -12;
    }

    public void changeBirdImage() {
        if (birdSpeed == 0) {
            birdImage = normalBirdImage;
        } else if (birdSpeed > 0 && birdSpeed < birdBaseSpeed -4) {
            birdImage = birdSemiFallingImage;
        } else if (birdSpeed < 0 ) {
            birdImage = birdJumpImage;
        } else {
            birdImage = birdFallingImage;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            jump();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            jump();
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


    public void setBirdSpeed(int birdSpeed) {
        this.birdSpeed = birdSpeed;
    }

    public int getBirdBaseSpeed() {
        return birdBaseSpeed;
    }

    public ImageIcon getNormalBirdImage() {
        return normalBirdImage;
    }

    public void setBirdImage(ImageIcon birdImage) {
        this.birdImage = birdImage;
    }
}
