public class PipePair {
    private Pipe topPipe;
    private Pipe bottomPipe;

    public PipePair(Pipe topPipe, Pipe bottomPipe) {
        this.topPipe = topPipe;
        this.bottomPipe = bottomPipe;
    }

    public Pipe getTopPipe() {
        return topPipe;
    }

    public Pipe getBottomPipe() {
        return bottomPipe;
    }
}
