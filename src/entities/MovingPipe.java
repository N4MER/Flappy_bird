package entities;

import entities.Pipe;
import gameLogic.Game;

import javax.swing.*;

public class MovingPipe extends Pipe {

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
