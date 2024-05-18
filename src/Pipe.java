import javax.swing.*;

public class Pipe {
    private int pipeX;
    private int pipeY;
    private int pipeHeight;
    private int pipeWidth;
    private ImageIcon pipeImage;

    private boolean passed;


    public Pipe(int pipeY, ImageIcon pipeImage, ImageIcon background) {
        this.pipeImage = pipeImage;
        this.pipeHeight = this.pipeImage.getIconHeight();
        this.pipeWidth = this.pipeImage.getIconWidth();
        this.pipeX = background.getIconWidth() - pipeWidth;
        this.pipeY = pipeY;
        this.passed = false;
    }

    public void moveUp() {
    }


    public int getPipeX() {
        return pipeX;
    }

    public void setPipeX(int pipeX) {
        this.pipeX = pipeX;
    }

    public int getPipeY() {
        return pipeY;
    }

    public int getPipeHeight() {
        return pipeHeight;
    }

    public int getPipeWidth() {
        return pipeWidth;
    }

    public ImageIcon getPipeImage() {
        return pipeImage;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public void setPipeY(int pipeY) {
        this.pipeY = pipeY;
    }

    public void move(int gameSpeed) {
        pipeX -= gameSpeed;
    }

}
