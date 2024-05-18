import javax.swing.*;
import java.util.InputMismatchException;

public class CreatePipes {
    private PipePair pipePair;

    public static PipePair createPipes(int pipe, int pipeY, ImageIcon topPipeImage, ImageIcon bottomPipeImage, ImageIcon background, Game game) {
        switch (pipe) {
            case 1:
                return new PipePair(new Pipe(pipeY, topPipeImage, background), new Pipe(pipeY, bottomPipeImage, background));
            case 2:
                return new PipePair(new MovingPipe(pipeY, topPipeImage, background, game), new MovingPipe(pipeY, bottomPipeImage, background, game));
            case 3:
                return new PipePair(new Pipe(pipeY, topPipeImage, background), new Pipe(pipeY, bottomPipeImage, background));
            default:
                return  null;
        }
    }
}
