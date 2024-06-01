package entities;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * The type Bird.
 */
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
    private int jumpForce = -13;

    /**
     * Instantiates a new Bird.
     *
     * @param birdImageName            the bird image name
     * @param birdFallingImageName     the bird falling image name
     * @param birdSemiFallingImageName the bird semi falling image name
     * @param birdJumpImageName        the bird jump image name
     */
    public Bird(String birdImageName, String birdFallingImageName, String birdSemiFallingImageName, String birdJumpImageName) {
        birdImage = new ImageIcon(birdImageName);
        normalBirdImage = birdImage;
        birdFallingImage = new ImageIcon(birdFallingImageName);
        birdSemiFallingImage = new ImageIcon(birdSemiFallingImageName);
        birdJumpImage = new ImageIcon(birdJumpImageName);
        birdHeight = birdImage.getIconHeight();
        birdWidth = birdImage.getIconWidth();
    }

    /**
     * Bird movement.
     * If bird tries to go beyond Y0 coordinate it will set birds Y to 0 and reduce its speed.
     * Makes bird fall.
     * @param background the background
     */
    public void birdMovement(ImageIcon background) {
        fall();
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

    /**
     * Fall.
     * Increases birdSpeed by gravity.
     */
    public void fall(){
        birdSpeed += gravity;
    }

    /**
     * Jump.
     * Sets birdSpeed to jumpForce
     */
    public void jump() {
        birdSpeed = jumpForce;
    }

    /**
     * Change bird image.
     * Changes bird image depending on the bird speed.
     */
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

    /**
     * Gets bird image.
     *
     * @return the bird image
     */
    public ImageIcon getBirdImage() {
        return birdImage;
    }


    /**
     * Gets bird height.
     *
     * @return the bird height
     */
    public int getBirdHeight() {
        return birdHeight;
    }

    /**
     * Gets bird width.
     *
     * @return the bird width
     */
    public int getBirdWidth() {
        return birdWidth;
    }

    /**
     * Gets bird x.
     *
     * @return the bird x
     */
    public int getBirdX() {
        return birdX;
    }

    /**
     * Sets bird x.
     *
     * @param birdX the bird x
     */
    public void setBirdX(int birdX) {
        this.birdX = birdX;
    }

    /**
     * Gets bird y.
     *
     * @return the bird y
     */
    public int getBirdY() {
        return birdY;
    }

    /**
     * Sets bird y.
     *
     * @param birdY the bird y
     */
    public void setBirdY(int birdY) {
        this.birdY = birdY;
    }


    /**
     * Sets bird speed.
     *
     * @param birdSpeed the bird speed
     */
    public void setBirdSpeed(int birdSpeed) {
        this.birdSpeed = birdSpeed;
    }

    /**
     * Gets bird base speed.
     *
     * @return the bird base speed
     */
    public int getBirdBaseSpeed() {
        return birdBaseSpeed;
    }

    /**
     * Gets normal bird image.
     *
     * @return the normal bird image
     */
    public ImageIcon getNormalBirdImage() {
        return normalBirdImage;
    }

    /**
     * Sets bird image.
     *
     * @param birdImage the bird image
     */
    public void setBirdImage(ImageIcon birdImage) {
        this.birdImage = birdImage;
    }

    /**
     * Sets bird height.
     *
     * @param birdHeight the bird height
     */
    public void setBirdHeight(int birdHeight) {
        this.birdHeight = birdHeight;
    }

    /**
     * Sets bird width.
     *
     * @param birdWidth the bird width
     */
    public void setBirdWidth(int birdWidth) {
        this.birdWidth = birdWidth;
    }

    /**
     * Sets bird base speed.
     *
     * @param birdBaseSpeed the bird base speed
     */
    public void setBirdBaseSpeed(int birdBaseSpeed) {
        this.birdBaseSpeed = birdBaseSpeed;
    }

    /**
     * Gets bird speed.
     *
     * @return the bird speed
     */
    public int getBirdSpeed() {
        return birdSpeed;
    }

    /**
     * Gets gravity.
     *
     * @return the gravity
     */
    public int getGravity() {
        return gravity;
    }

    /**
     * Sets gravity.
     *
     * @param gravity the gravity
     */
    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    /**
     * Gets jump force.
     *
     * @return the jump force
     */
    public int getJumpForce() {
        return jumpForce;
    }

    /**
     * Sets jump force.
     *
     * @param jumpForce the jump force
     */
    public void setJumpForce(int jumpForce) {
        this.jumpForce = jumpForce;
    }
}
