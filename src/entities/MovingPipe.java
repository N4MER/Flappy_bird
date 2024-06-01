package entities;

import gameLogic.Game;

import javax.swing.*;

/**
 * The type Moving pipe.
 */
public class MovingPipe extends Pipe {

    /**
     * Instantiates a new Moving pipe.
     *
     * @param pipeY           the pipe y
     * @param pipeImage       the pipe image
     * @param background      the background
     * @param game            the game
     * @param isTopPipe       the is top pipe
     * @param randomDirection the random direction
     */
    public MovingPipe(int pipeY, ImageIcon pipeImage, ImageIcon background, Game game, boolean isTopPipe, int randomDirection) {
        super(pipeY, pipeImage, background, game, isTopPipe,randomDirection);

    }

    @Override
    public void moveUp() {
        setPipeY(getPipeY() - 1);
    }

    @Override
    public void moveDown() {
        setPipeY(getPipeY() + 1);
    }
}
