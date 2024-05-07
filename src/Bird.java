import javax.swing.*;
import java.awt.*;

public class Bird {
    private ImageIcon birdImage;
    private int birdHeight;
    private int birdWidth;
    private int birdX;
    private int birdY;

    public Bird(String birdImageName) {
        this.birdImage = new ImageIcon(birdImageName);
        this.birdHeight = birdImage.getIconHeight();
        this.birdWidth = birdImage.getIconWidth();
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
}
