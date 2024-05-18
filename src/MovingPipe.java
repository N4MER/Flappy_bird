import javax.swing.*;

public class MovingPipe extends Pipe {
    private int xUpperLimit;
    private int xBottomLimit;

    public MovingPipe(int pipeY, ImageIcon pipeImage, ImageIcon background, Game game) {
        super(pipeY, pipeImage, background);
        xUpperLimit = game.getPipeMaxY();
        xBottomLimit = game.getPipeMinY();
    }

    public void moveUp() {
        setPipeY(getPipeY() + 1);
    }


}
