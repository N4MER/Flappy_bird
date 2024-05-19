import javax.swing.*;

public class CreatePipes {

    public static PipePair createPipes(int pipe, int pipeY, ImageIcon topPipeImage, ImageIcon bottomPipeImage, ImageIcon background, Game game, boolean isTopPipe, int randomDirection) {
        switch (pipe) {
            case 1:
            case 3:
                return new PipePair(new Pipe(pipeY, topPipeImage, background, game, isTopPipe, randomDirection), new Pipe(pipeY, bottomPipeImage, background, game, isTopPipe, randomDirection));
            case 2:
                return new PipePair(new MovingPipe(pipeY, topPipeImage, background, game, isTopPipe, randomDirection), new MovingPipe(pipeY, bottomPipeImage, background, game, isTopPipe, randomDirection));
            default:
                return null;
        }
    }
}
