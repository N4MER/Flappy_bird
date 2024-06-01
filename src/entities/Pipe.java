package entities;

import gameLogic.Direction;
import gameLogic.Game;

import javax.swing.*;
/**
 * The type Pipe.
 */
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

    /**
     * Instantiates a new Pipe.
     *
     * @param pipeY           the pipe y
     * @param pipeImage       the pipe image
     * @param background      the background
     * @param game            the game
     * @param isTopPipe       the is top pipe
     * @param randomDirection the random direction
     */
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

    /**
     * Sets first direction.
     *
     * @param randomDirection the random direction
     */
    public void setFirstDirection(int randomDirection) {
        if (randomDirection == 1) {
            direction = Direction.DOWN;
        } else {
            direction = Direction.UP;
        }
    }

    /**
     * Move up.
     */
    public void moveUp() {
    }

    /**
     * Move down.
     */
    public void moveDown() {
    }

    /**
     * Move.
     * Moves pipe up or down depending on the direction.
     * If it exceeds minimal or maximal Y it changes the direction.
     * Moves all pipes forward.
     * @param game the game
     */
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

    /**
     * Choose direction.
     * Moves pipe up or down depending on the direction
     */
    public void chooseDirection() {
        if (direction.equals(Direction.DOWN)) {
            moveDown();
        } else if (direction.equals(Direction.UP)) {
            moveUp();
        }
    }

    /**
     * Move forward.
     * Moves the pipe forward.
     * @param gameSpeed the game speed
     */
    public void moveForward(int gameSpeed) {
        pipeX -= gameSpeed;
    }

    /**
     * Gets pipe x.
     *
     * @return the pipe x
     */
    public int getPipeX() {
        return pipeX;
    }

    /**
     * Gets pipe y.
     *
     * @return the pipe y
     */
    public int getPipeY() {
        return pipeY;
    }

    /**
     * Gets pipe height.
     *
     * @return the pipe height
     */
    public int getPipeHeight() {
        return pipeHeight;
    }

    /**
     * Gets pipe width.
     *
     * @return the pipe width
     */
    public int getPipeWidth() {
        return pipeWidth;
    }

    /**
     * Gets pipe image.
     *
     * @return the pipe image
     */
    public ImageIcon getPipeImage() {
        return pipeImage;
    }

    /**
     * Is passed boolean.
     *
     * @return the boolean
     */
    public boolean isPassed() {
        return passed;
    }

    /**
     * Sets passed.
     *
     * @param passed the passed
     */
    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    /**
     * Sets pipe y.
     *
     * @param pipeY the pipe y
     */
    public void setPipeY(int pipeY) {
        this.pipeY = pipeY;
    }

    /**
     * Sets pipe x.
     *
     * @param pipeX the pipe x
     */
    public void setPipeX(int pipeX) {
        this.pipeX = pipeX;
    }

    /**
     * Is top pipe boolean.
     *
     * @return the boolean
     */
    public boolean isTopPipe() {
        return isTopPipe;
    }

    /**
     * Sets pipe height.
     *
     * @param pipeHeight the pipe height
     */
    public void setPipeHeight(int pipeHeight) {
        this.pipeHeight = pipeHeight;
    }

    /**
     * Sets pipe width.
     *
     * @param pipeWidth the pipe width
     */
    public void setPipeWidth(int pipeWidth) {
        this.pipeWidth = pipeWidth;
    }
}
