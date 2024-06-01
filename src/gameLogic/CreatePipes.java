package gameLogic;

import entities.MovingPipe;
import entities.Pipe;

import javax.swing.*;

/**
 * The type Create pipes.
 */
public class CreatePipes {

    /**
     * Create pipes pipe pair.
     * Factory method for creating pipes.
     * @param pipe            the pipe
     * @param pipeY           the pipe y
     * @param topPipeImage    the top pipe image
     * @param bottomPipeImage the bottom pipe image
     * @param background      the background
     * @param game            the game
     * @param isTopPipe       the is top pipe
     * @param randomDirection the random direction
     * @return the pipe pair
     */
    public static PipePair createPipes(int pipe, int pipeY, ImageIcon topPipeImage, ImageIcon bottomPipeImage, ImageIcon background, Game game, boolean isTopPipe, int randomDirection) {
        switch (pipe) {
            case 1:
                return new PipePair(
                        new MovingPipe(pipeY, topPipeImage, background, game, isTopPipe, randomDirection),
                        new MovingPipe(pipeY, bottomPipeImage, background, game, isTopPipe, randomDirection)
                );
            default:
                return new PipePair(
                        new Pipe(pipeY, topPipeImage, background, game, isTopPipe, randomDirection),
                        new Pipe(pipeY, bottomPipeImage, background, game, isTopPipe, randomDirection)
                );
        }
    }
}
