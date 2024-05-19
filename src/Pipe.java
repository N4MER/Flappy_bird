import javax.swing.*;
import java.util.Random;

public class Pipe {
    private int pipeX;
    private int pipeY;
    private int pipeHeight;
    private int pipeWidth;
    private ImageIcon pipeImage;
    private int xUpperLimit;
    private int xBottomLimit;
    private Direction direction;
    private int xMoveVolume;
    private boolean isTopPipe;

    private boolean passed;
    private int randomDirection;


    public Pipe(int pipeY, ImageIcon pipeImage, ImageIcon background, Game game, boolean isTopPipe, int randomDirection) {
        this.pipeImage = pipeImage;
        pipeHeight = pipeImage.getIconHeight();
        pipeWidth = pipeImage.getIconWidth();
        pipeX = background.getIconWidth() - pipeWidth;
        this.pipeY = pipeY;
        xUpperLimit = game.getPipeMinY();
        xBottomLimit = game.getPipeMaxY();
        direction = Direction.DOWN;
        xMoveVolume = 1;
        setFirstDirection(randomDirection);
        this.isTopPipe = isTopPipe;
        passed = false;
    }

    public void setFirstDirection(int randomDirection) {
        if (randomDirection == 1) {
            direction = Direction.DOWN;
        } else {
            direction = Direction.UP;
        }
    }

    public void moveUp() {
    }

    public void moveDown() {
    }

    public void move(Game game) {
        if (!isTopPipe) {
            if (pipeY - xMoveVolume - game.getPipeGap() < xUpperLimit) {
                direction = Direction.DOWN;
            } else if (pipeY + xMoveVolume > xBottomLimit) {
                direction = Direction.UP;
            }
            chooseDirection();
        } else {
            if (pipeY - xMoveVolume + pipeImage.getIconHeight() < xUpperLimit) {
                direction = Direction.DOWN;
            } else if (pipeY + game.getPipeGap() + pipeImage.getIconHeight() + xMoveVolume > xBottomLimit) {
                direction = Direction.UP;
            }
            chooseDirection();
        }
        moveForward(game.getGameSpeed());
    }

    public void chooseDirection() {
        if (direction.equals(Direction.DOWN)) {
            moveDown();
        } else if (direction.equals(Direction.UP)) {
            moveUp();
        }
    }

    public void moveForward(int gameSpeed) {
        pipeX -= gameSpeed;
    }

    public int getPipeX() {
        return pipeX;
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


}
