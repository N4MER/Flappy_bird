package gameLogic;

import entities.Pipe;

/**
 * The type Pipe pair.
 */
public class PipePair {
    private Pipe topPipe;
    private Pipe bottomPipe;

    /**
     * Instantiates a new Pipe pair.
     *
     * @param topPipe    the top pipe
     * @param bottomPipe the bottom pipe
     */
    public PipePair(Pipe topPipe, Pipe bottomPipe) {
        this.topPipe = topPipe;
        this.bottomPipe = bottomPipe;
    }

    /**
     * Gets top pipe.
     *
     * @return the top pipe
     */
    public Pipe getTopPipe() {
        return topPipe;
    }

    /**
     * Gets bottom pipe.
     *
     * @return the bottom pipe
     */
    public Pipe getBottomPipe() {
        return bottomPipe;
    }
}
