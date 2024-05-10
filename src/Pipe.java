import javax.swing.*;

public class Pipe{
    private int pipeX;
    private int pipeY;
    private int pipeHeight;
    private int pipeWidth;
    private ImageIcon pipeImage;
    private int moveSpeed = 8;


    public Pipe(int pipeY, ImageIcon pipeImage,ImageIcon background) {
        this.pipeImage = pipeImage;
        this.pipeHeight = this.pipeImage.getIconHeight();
        this.pipeWidth = this.pipeImage.getIconWidth();
        this.pipeX = background.getIconWidth() - pipeWidth;
        this.pipeY = pipeY;

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

    public void setPipeY(int pipeY) {
        this.pipeY = pipeY;
    }

    public int getPipeHeight() {
        return pipeHeight;
    }

    public void setPipeHeight(int pipeHeight) {
        this.pipeHeight = pipeHeight;
    }

    public int getPipeWidth() {
        return pipeWidth;
    }

    public void setPipeWidth(int pipeWidth) {
        this.pipeWidth = pipeWidth;
    }

    public ImageIcon getPipeImage() {
        return pipeImage;
    }

    public void setPipeImage(ImageIcon pipeImage) {
        this.pipeImage = pipeImage;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }

}
