import javax.swing.*;

public class Pipes {
    private int pipeX;
    private int pipeY;
    private int pipeHeight;
    private int pipeWidth;
    private ImageIcon pipe;

    public Pipes(int pipeX, int pipeY, String imageName) {
        this.pipeX = pipeX;
        this.pipeY = pipeY;
        this.pipe = new ImageIcon(imageName);
        pipeHeight = pipe.getIconHeight();
        pipeWidth = pipe.getIconWidth();

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

    public ImageIcon getPipe() {
        return pipe;
    }

    public void setPipe(ImageIcon pipe) {
        this.pipe = pipe;
    }
}
